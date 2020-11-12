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
 * @author andre
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class NotificacionesDTO {

    private Long id;
    private Date fecha_envio;
    private Date fecha_entrega;
    private String mensaje;
    private String emisor;
    private String receptor;
    private boolean estado;
    private UsuariosDTO usuarios;

}
