/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
 * @author andre
 */
@Service
public class AuthenticationServiceImplementation implements IAuthenticationService, UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private IUsuariosService usuarioService;

    @Autowired
    private IUsuariosRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuarios> usuarioBuscado = usuarioService.findByCedula(username);
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
    @Transactional(readOnly = true)
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getCedula(), authenticationRequest.getContrasena()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        Optional<Usuarios> usuario = usuarioService.findByCedula(authenticationRequest.getCedula());

        if (usuario.isPresent()) {
            authenticationResponse.setJwt(jwtProvider.generateToken(authenticationRequest));

            UsuariosDTO usuarioDto = MapperUtils.DtoFromEntity(usuario.get(), UsuariosDTO.class);
            authenticationResponse.setUsuario(usuarioDto);

            RolesDTO rolesDto = MapperUtils.DtoFromEntity(usuario.get().getRoles(), RolesDTO.class);
            authenticationResponse.setRoles(rolesDto);

            return authenticationResponse;
        } else {
            return null;
        }

    }
}
