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
    private Roles rol;

    @ManyToOne
    @JoinColumn(name = "Empleado_id")
    private Usuarios empleado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Usuarios> empleados = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
//    private List<Usuarios_Areas> usuariosAreas = new ArrayList<>();
//
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Marcas_horario> marcasHorarios = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
//    private List<Notificaciones> notificaciones = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
//    private List<Horarios> horarios = new ArrayList<>();
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nombre", length = 45)

    private String nombre;

    @Column(name = "apellidos", length = 45)

    private String apellidos;

    @Column(name = "correo", length = 60)

    private String correo;
    
    @Column(length = 100, name = "contraseña_Encriptada")

    private String contraseñaEncriptada;

    @Column(length = 25, unique = true)

    private String cedula;

    @Column

    private byte estado;

    @Column(name = "Fecha_registro", updatable = false)

    @Temporal(TemporalType.DATE)

    @Setter(AccessLevel.NONE)

    private Date Fecha_registro;

    private static final long serialVersionUID = 1L;

    @PrePersist

    public void prePersist() {

        estado = 1;
        Fecha_registro = new Date();

    }

}
