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
import org.una.tramites_aeropuerto.entities.Areas_trabajo;

/**
 *
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class HorariosDTO {
   
    private Long id;
    private Date Dia_Entrada;
    private Date Dia_Salida;
    Areas_trabajo areas_trabajo;
//   private Usuarios_Areas usuarios_areas;
}
