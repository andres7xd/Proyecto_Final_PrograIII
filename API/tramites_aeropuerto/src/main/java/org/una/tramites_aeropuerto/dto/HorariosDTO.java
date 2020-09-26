/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.dto;

import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.tramites_aeropuerto.entities.Usuarios_Areas;

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
    private int Dia_Entrada;
    private int Dia_Salida;
     private Time Hora_entrada;
    private Time Hora_Salida;
    private Usuarios_Areas usuarios_areas;
   
}
