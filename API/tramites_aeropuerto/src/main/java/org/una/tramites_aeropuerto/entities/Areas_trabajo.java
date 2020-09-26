/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.entities;

import java.io.Serializable;
import java.util.ArrayList;
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

@Table(name = "Areas_trabajo")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Areas_trabajo implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Marcas_horario_id")
    private Marcas_horario marcas_horario;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "areas_trabajo")
  private List<Usuarios_Areas> usuarios_areas = new ArrayList<>();
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", length = 20)
    private String nombre;
}
