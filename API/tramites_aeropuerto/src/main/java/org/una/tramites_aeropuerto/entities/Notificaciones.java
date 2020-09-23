/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author andre
 */
@Table(name = "notificaciones")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString

public class Notificaciones implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha_envio")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fecha_envio;
    
    @Column(name = "fecha_lectura")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fecha_lectura;
    
    @Column(name = "mensaje", length = 100)
    private String mensaje;
    
    @Column(name = "emisor", length = 100)
    private String emisor;
    
    @Column
    private byte estado;
    
     public void prePersist() {

       estado = 1;
       fecha_envio = new Date();
       fecha_lectura = new Date();

    }

    
    
}