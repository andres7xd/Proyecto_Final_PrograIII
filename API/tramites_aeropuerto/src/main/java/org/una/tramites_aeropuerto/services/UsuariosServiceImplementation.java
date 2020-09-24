/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.tramites_aeropuerto.dto.AuthenticationRequest;
import org.una.tramites_aeropuerto.entities.Usuarios;
import org.una.tramites_aeropuerto.repositories.IUsuariosRepository;

/**
 *
 * @author rache
 */
@Service
public class UsuariosServiceImplementation implements IUsuariosService {

//    @Autowired
//    private AuthenticationManager authenticationManager;
//    
//    @Autowired
//    private JwtProvider jwtProvider;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
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
    public Optional<List<Usuarios>> findByNombreAproximateIgnoreCase(String nombre) {
        return Optional.ofNullable(usuariosRepository.findByNombreContainingIgnoreCase(nombre));
    }

    @Override
    @Transactional
    public Usuarios create(Usuarios usuario) {
//        encriptarPassword(usuario);
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

    @Transactional()
    public Usuarios findByNombreCompleto(String nombre) {
        return usuariosRepository.findByNombre(nombre);
    }

    @Override
    public Optional<List<Usuarios>> findByRolId(Long id) {
        return Optional.ofNullable(usuariosRepository.findByRolId(id));
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
    public Optional<List<Usuarios>> findByApellidosAproximateIgnoreCase(String apellidos) {
        return Optional.ofNullable(usuariosRepository.findByNombreContainingIgnoreCase(apellidos));
    }

    @Override
    public Optional<List<Usuarios>> findByEmpleadoId(Long id) {
        return Optional.ofNullable(usuariosRepository.findByEmpleadoId(id));
    }

    @Override
    public Optional<Usuarios> login(Usuarios usuario) {
        return Optional.ofNullable(usuariosRepository.findByCedulaAndContraseñaEncriptada(usuario.getCedula(), usuario.getContraseñaEncriptada()));
    }

//    private void encriptarPassword(Usuario usuario) {
//        String password = usuario.getPasswordEncriptado();
//        if (!password.isBlank()) {
//            usuario.setPasswordEncriptado(bCryptPasswordEncoder.encode(password));
//        }
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Usuario> usuarioBuscado = findByCedula(username);
//        if (usuarioBuscado.isPresent()) {
//            Usuario usuario = usuarioBuscado.get();
//            List<GrantedAuthority> roles = new ArrayList<>();
//            roles.add(new SimpleGrantedAuthority("ADMIN"));
//            UserDetails userDetails = new User(usuario.getCedula(),
//                    usuario.getPasswordEncriptado(), roles);
//            return userDetails;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public String login(AuthenticationRequest authenticationRequest) {
//
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getCedula(), authenticationRequest.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return jwtProvider.generateToken(authenticationRequest);
//
//    }
}
