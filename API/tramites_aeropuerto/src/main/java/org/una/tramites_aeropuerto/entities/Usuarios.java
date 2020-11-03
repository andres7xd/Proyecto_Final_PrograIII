/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
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
 * @author rache
 */
@Entity

@Table(name = "usuarios")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString

public class Usuarios implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Rol_id")
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "jefe_id")
    private Usuarios empleado;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NombreCompleto", length = 80)
    private String nombreCompleto;
    
    @Column(name = "Correo", length = 60)
    private String correo;

    @Column(length = 100, name = "contrasena_Encriptada")
    private String contrasenaEncriptada;

    @Column(length = 25, unique = true)
    private String cedula;
    
    @Column(name = "estado")
    private boolean estado;

    @Column(name = "Fecha_registro")
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date Fecha_registro;

    private static final long serialVersionUID = 1L;

    @PrePersist

    public void prePersist() {

        estado = true;
        Fecha_registro = new Date();

    }

}
