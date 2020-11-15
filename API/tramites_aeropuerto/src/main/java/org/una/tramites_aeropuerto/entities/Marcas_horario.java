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
    @JoinColumn(name = "id_usuarios_areas")
    private Usuarios_Areas usuariosAreas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "marca_entrada")
    @Temporal(TemporalType.TIME)
    private Date marca_entrada;

    @Column(name = "marca_salida")
    @Temporal(TemporalType.TIME)
    private Date marca_salida;

    @Column(name = "estado")
    private boolean estado;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {

        marca_entrada = new Date();
        estado = true;
    }

}
