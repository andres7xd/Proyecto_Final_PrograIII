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
    private boolean estado;
    private Date Fecha_registro;
    private String contrasenaEncriptada;
    private UsuariosDTO empleado;
    private RolesDTO roles;
}
