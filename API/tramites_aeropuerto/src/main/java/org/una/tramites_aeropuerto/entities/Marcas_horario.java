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
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @ManyToOne
    @JoinColumn(name = "id_area_trabajo")
    private Areas_trabajo Areas_trabajo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca_entrada")
    private Time marca_entrada;

    @Column(name = "marca_salida")
    private Time marca_salida;

    @Column(name = "estado")
    private boolean estado;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {

        estado = true;
    }

}
