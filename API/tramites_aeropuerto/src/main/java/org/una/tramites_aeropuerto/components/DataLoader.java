/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.components;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.tramites_aeropuerto.entities.Roles;
import org.una.tramites_aeropuerto.entities.Usuarios;
import org.una.tramites_aeropuerto.services.IRolesService;
import org.una.tramites_aeropuerto.services.IUsuariosService;

/**
 *
 * @author rache
 */
@Component
public class DataLoader implements ApplicationRunner {

    @Value("${app.admin-user}")
    private String cedula;

    @Value("${app.contraseña}")
    private String contraseña;

    @Autowired
    private IUsuariosService usuarioService;

    @Autowired
    private IRolesService rolService;
//
//    @Autowired
//    private IPermisoOtorgadoService permisoOtorgadoService;

    @Override
    public void run(ApplicationArguments args) {

        if (usuarioService.findByCedula(cedula).isEmpty()) {

            Roles rol;
            final String TipoRol = "Administrador"; 
            Optional<Roles> rolBuscado = rolService.findByNombreAproximateIgnoreCase(TipoRol);

            if (rolBuscado.isEmpty()) { 
                rol = new Roles();
                rol.setNombre(TipoRol);
                rol = rolService.create(rol);

            } else {
                rol = rolBuscado.get();
            }
            
            Usuarios usuario = new Usuarios();
            usuario.setNombreCompleto("Usuario ADMIN");
            usuario.setCedula(cedula);
            usuario.setContraseñaEncriptada(contraseña);
            usuario.setRol(rol);
            usuario = usuarioService.create(usuario);

            System.out.println("Se agrega el usuario inicial");
        } else {
            System.out.println("Se encontro el Usuario");
        }

    }
}