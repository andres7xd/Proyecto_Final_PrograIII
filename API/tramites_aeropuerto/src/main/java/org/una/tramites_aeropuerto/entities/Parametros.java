/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Luis
 */

@Entity

@Table(name = "parametros")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Parametros {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 80)
    private String nombre;
    
    @Column(name = "vigenciaEnMinutos")
    private int vigenciaEnMinutos; 
    
    @Column(name = "estado")
    private boolean estado;

    @PrePersist
    public void prePersist() {

        estado = true;
    }
}
