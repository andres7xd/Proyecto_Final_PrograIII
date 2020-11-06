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
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HorariosDTO {
    private Long id;
    private String diaEntrada;
    private String diaSalida;
    private boolean estado;
    private Date hora_entrada;
    private Date hora_salida;
    private Areas_trabajoDTO areas_trabajo;
    
}
