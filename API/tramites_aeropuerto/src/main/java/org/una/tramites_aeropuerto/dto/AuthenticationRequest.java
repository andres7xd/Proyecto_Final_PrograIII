/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.dto;

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
public class AuthenticationRequest {
    private String cedula;
 private String contraseña;

}
