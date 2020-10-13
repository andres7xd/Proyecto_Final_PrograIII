/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "imagenes")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Imagenes implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "notificaiones_id")
    private Notificaciones notificaciones;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "imagen_adjunta", length = 40000)
    private String Imagen_Adjunta;
    
    @Column(name = "parte")
    private int parte;
    
    @Column(name = "totalParte")
    private int totalParte;
    
}
