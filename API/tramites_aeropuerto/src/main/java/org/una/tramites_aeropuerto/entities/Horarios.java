/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.entities;

import java.io.Serializable;
import java.sql.Time;
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
 * @author Luis
 */
@Entity

@Table(name = "Horarios")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Horarios implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_Usuario_Area")
    private Usuarios_Areas Usuarios_Areas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Dia_Entrada", updatable = false)
    private int Dia_entrada;

    @Column(name = "Dia_Salida", updatable = false)
    private int Dia_Salida;

    @Column(name = "Hora_Entrada", updatable = false)
    private Time Hora_entrada;
    
    @Column(name = "Hora_Salida", updatable = false)
    private Time Hora_Salida;

}
