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
 * @author andre
 */
@Entity
@Table(name = "notificaciones")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString

public class Notificaciones implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    private Usuarios usuarios;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fecha_envio;

    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fecha_entrega;

    @Column(name = "mensaje", length = 100)
    private String mensaje;

    @Column(name = "emisor", length = 100)
    private String emisor;

    @Column(name = "receptor", length = 100)
    private String receptor;

    @Column(name = "estado")
    private boolean estado;

    @PrePersist
    public void prePersist() {

        estado = true;
        fecha_envio = new Date();
    }

}
