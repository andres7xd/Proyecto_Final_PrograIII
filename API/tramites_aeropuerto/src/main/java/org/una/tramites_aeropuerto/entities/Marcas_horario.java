/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.entities;

/**
 *
 * @author rache
 */
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

@Table(name = "marcas_horario")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString

public class Marcas_horario implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcas_horario")
    private List<Areas_trabajo> areas_trabajo = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Hora_Entrada", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date Hora_Entrada;

    @Column(name = "Hora_Salida")
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date Hora_Salida;

    @Column(name = "Horario", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date Horario;

    private static final long serialVersionUID = 1L;

    @PrePersist

    public void prePersist() {

        Horario = new Date();
        Hora_Entrada = new Date();
        Hora_Salida = new Date();

    }

}
