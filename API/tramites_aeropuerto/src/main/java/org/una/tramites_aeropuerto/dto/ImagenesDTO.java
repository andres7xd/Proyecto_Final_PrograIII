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
import org.una.tramites_aeropuerto.entities.Notificaciones;

/**
 *
 * @author andre
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImagenesDTO {

    private Long id;
    private String parte;
    private int orden;
    private int total_partes;
    private Notificaciones notificaciones;

}
