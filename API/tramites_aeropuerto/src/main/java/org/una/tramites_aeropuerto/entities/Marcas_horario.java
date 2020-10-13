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

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "hora_entrada", updatable = false)

    @Temporal(TemporalType.DATE)

    @Setter(AccessLevel.NONE)

    private Date Hora_Entrada;

    @Column(name = "hora_salida", updatable = false)

    @Temporal(TemporalType.DATE)

    @Setter(AccessLevel.NONE)

    private Date Hora_Salida;

    @Column(name = "horario", updatable = false)

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
