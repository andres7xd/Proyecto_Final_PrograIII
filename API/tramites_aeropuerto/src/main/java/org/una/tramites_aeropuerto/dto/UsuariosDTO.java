/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.tramites_aeropuerto.entities.Roles;
import org.una.tramites_aeropuerto.entities.Usuarios;

/**
 *
 * @author rache
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuariosDTO {

    private Long id;
    private String nombreCompleto;
    private String cedula;
    private String correo;
    private byte estado;
    private Date Fecha_Registro;
    private Usuarios jefe;
    private Roles rolid;
}
