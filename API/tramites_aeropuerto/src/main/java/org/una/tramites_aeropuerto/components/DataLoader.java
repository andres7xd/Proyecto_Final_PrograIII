/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.components;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.tramites_aeropuerto.dto.RolesDTO;
import org.una.tramites_aeropuerto.dto.UsuariosDTO;
import org.una.tramites_aeropuerto.loaders.Permisos;
import org.una.tramites_aeropuerto.reports.ConeccionReporte;
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

    @Value("${app.contrasena}")
    private String contrasena;

    @Autowired
    private IUsuariosService usuarioService;

    @Autowired
    private IRolesService rolService;

    @Override
    public void run(ApplicationArguments args) {

             ConeccionReporte coneccionreporte = new ConeccionReporte();
                coneccionreporte.Connecion("mm");
                
        if (usuarioService.findByCedula(cedula).isEmpty()) {

            RolesDTO rol;
            final String TipoRol = "Administrador";
            Optional<RolesDTO> rolBuscado = rolService.findByNombreAproximateIgnoreCase(TipoRol);

            if (rolBuscado.isEmpty()) {
                rol = new RolesDTO();
                rol.setNombre(TipoRol);
                rol = rolService.create(rol);

            } else {
                rol = rolBuscado.get();
            }

            UsuariosDTO usuario = new UsuariosDTO();
            usuario.setNombreCompleto("Usuario ADMIN");
            usuario.setCorreo("@@@@");
            usuario.setCedula(cedula);
            usuario.setId(Long.MIN_VALUE);
//            usuario.setEmpleado(usuario);
            usuario.setContrasenaEncriptada(contrasena);
            usuario.setRoles(rol);
            usuario = usuarioService.create(usuario);

            System.out.println("Se agrega el usuario inicial");
        } else {
            System.out.println("Se encontro el Usuario");
        }
    }

    private void createPermisos() {
        for (Permisos permiso : Permisos.values()) {
            RolesDTO nuevorol = new RolesDTO();
            nuevorol.setNombre(nuevorol.getNombre());
            nuevorol = rolService.create(nuevorol);
        }
    }
}
