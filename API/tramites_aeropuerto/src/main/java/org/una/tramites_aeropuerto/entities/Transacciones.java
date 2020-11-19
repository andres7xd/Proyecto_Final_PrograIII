/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Luis
 */
@Entity

@Table(name = "transacciones")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Transacciones implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    private Usuarios usuarios;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "Fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date Fecha_registro;
    
  
    
    @Column(name = "estado")
    private boolean estado;
    
     public void prePersist() {

       estado = true;
       Fecha_registro = new Date();
      

    }
    
}
