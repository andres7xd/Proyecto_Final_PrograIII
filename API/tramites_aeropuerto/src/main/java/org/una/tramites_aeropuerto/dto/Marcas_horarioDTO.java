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
import org.una.tramites_aeropuerto.entities.Marcas_horario;
import org.una.tramites_aeropuerto.entities.Usuarios;

/**
 *
 * @author rache
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class Marcas_horarioDTO {

    private Long id;
    private Date Hora_Entrada;
    private Date Hora_Salida;
    private Marcas_horario marcas_horario;

}
