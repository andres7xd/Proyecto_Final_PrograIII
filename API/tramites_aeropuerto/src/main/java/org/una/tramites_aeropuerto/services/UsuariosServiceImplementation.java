/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.una.tramites_aeropuerto.dto.AuthenticationRequest;
import org.una.tramites_aeropuerto.dto.AuthenticationResponse;
import org.una.tramites_aeropuerto.dto.RolesDTO;
import org.una.tramites_aeropuerto.dto.UsuariosDTO;

import org.una.tramites_aeropuerto.entities.Usuarios;
import org.una.tramites_aeropuerto.jwt.JwtProvider;
import org.una.tramites_aeropuerto.repositories.IUsuariosRepository;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class UsuariosServiceImplementation implements IUsuariosService,UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IUsuariosRepository usuariosRepository;

    @Override
    public Optional<List<Usuarios>> findAll() {
        return Optional.ofNullable(usuariosRepository.findAll());
    }

    @Override
    public Optional<Usuarios> findById(Long id) {
        return usuariosRepository.findById(id);
    }

    @Override
    public Optional<List<Usuarios>> findByCedulaAproximate(String cedula) {
        return Optional.ofNullable(usuariosRepository.findByCedulaContaining(cedula));
    }

    @Override
    public Optional<List<Usuarios>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto) {
        return Optional.ofNullable(usuariosRepository.findByNombreCompletoContainingIgnoreCase(nombreCompleto));
    }

    @Override
    @Transactional
    public Usuarios create(Usuarios usuario) {
        encriptarContrasena(usuario);
        return usuariosRepository.save(usuario);
    }

    @Override
    @Transactional
    public Optional<Usuarios> update(Usuarios usuario, Long id) {
        if (usuariosRepository.findById(id).isPresent()) {
            return Optional.ofNullable(usuariosRepository.save(usuario));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        usuariosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        usuariosRepository.deleteAll();
    }

    @Override
    public Optional<List<Usuarios>> findByRolesId(Long id) {
        return Optional.ofNullable(usuariosRepository.findByRolesId(id));
    }

    @Override

    public Optional<Usuarios> findByCedula(String cedula) {
        return Optional.ofNullable(usuariosRepository.findByCedula(cedula));
    }

    @Override
    public Optional<List<Usuarios>> findByCorreoAproximate(String correo) {
        return Optional.ofNullable(usuariosRepository.findByCorreoContaining(correo));
    }

    @Override
    public Optional<List<Usuarios>> findByEmpleadoId(Long id) {
        return Optional.ofNullable(usuariosRepository.findByEmpleadoId(id));
    }

    private void encriptarContrasena(Usuarios usuario) {
        String password = usuario.getContrasenaEncriptada();
        if (!password.isBlank()) {
            usuario.setContrasenaEncriptada(bCryptPasswordEncoder.encode(password));
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuarios> usuarioBuscado = findByCedula(username);
        if (usuarioBuscado.isPresent()) {
            Usuarios usuario = usuarioBuscado.get();
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("ADMIN"));
            UserDetails userDetails = new User(usuario.getCedula(),
                    usuario.getContrasenaEncriptada(), roles);
            return userDetails;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getCedula(), authenticationRequest.getContrasena()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        Optional<Usuarios> usuario = findByCedula(authenticationRequest.getCedula());

        if (usuario.isPresent()) {
            authenticationResponse.setJwt(jwtProvider.generateToken(authenticationRequest));
           
            UsuariosDTO usuarioDto = MapperUtils.DtoFromEntity(usuario.get(), UsuariosDTO.class);
            authenticationResponse.setUsuario(usuarioDto);
            
            RolesDTO rolesDto = MapperUtils.DtoFromEntity(usuario.get(), RolesDTO.class);
            authenticationResponse.setRoles(rolesDto);

            return authenticationResponse;
        } else {
            return null;
        }

    }


    @Override
    public Optional<Usuarios> login(Usuarios usuario) {
        return Optional.ofNullable(usuariosRepository.findByCedulaAndContrasenaEncriptada(usuario.getCedula(), usuario.getContrasenaEncriptada()));
    }
}
