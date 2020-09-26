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
import org.una.tramites_aeropuerto.entities.Areas_trabajo;
import org.una.tramites_aeropuerto.entities.Usuarios;

/**
 *
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class Usuarios_AreasDto {
   
    private Long id;
    private Areas_trabajo area_trabajo;
    private Usuarios usuarios;
}
