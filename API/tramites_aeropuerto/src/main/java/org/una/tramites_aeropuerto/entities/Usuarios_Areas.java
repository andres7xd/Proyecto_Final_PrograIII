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

@Table(name = "Usuarios_Areas")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Usuarios_Areas implements Serializable {
//    @ManyToOne
//    @JoinColumn(name = "id_Usuario")
//    private Usuarios usuarios;
    
    @ManyToOne
    @JoinColumn(name = "id_Area_trabajo")
    private Areas_trabajo areas_trabajo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios_areas")
    private List<Horarios> horarios = new ArrayList<>();
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
