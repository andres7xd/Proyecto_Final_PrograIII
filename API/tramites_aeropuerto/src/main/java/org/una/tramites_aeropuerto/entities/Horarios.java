/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @JoinColumn(name = "id_area_trabajo")
    private Areas_trabajo areas_trabajo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Dia_Entrada", length = 20)
    private String Dia_Entrada;

    @Column(name = "Dia_Salida", length = 20)
    private String Dia_Salida;

    @Column(name = "estado")
    private boolean estado;

    @Basic(optional = false)
    @Column(name = "hora_entrada")
    @Temporal(TemporalType.TIME)
    private Date hora_entrada;

    @Basic(optional = false)
    @Column(name = "hora_salida")
    @Temporal(TemporalType.TIME)
    private Date hora_salida;

    @PrePersist
    public void prePersist() {

        hora_entrada = new Date();
        hora_salida = new Date();
        estado = true;
    }
}
