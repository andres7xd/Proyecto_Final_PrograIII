/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.entities.Usuarios_Areas;

/**
 *
 * @author Luis
 */
public interface IUsuarios_AreasService {
    
    public Optional<List<Usuarios_Areas>> findAll();
    
    public Optional<Usuarios_Areas> findById(Long id);
     
    public Usuarios_Areas create(Usuarios_Areas usuarios_areas);

    public Optional<Usuarios_Areas> update(Usuarios_Areas usuarios_areas, Long id);

    public void delete(Long id);

    public void deleteAll();
    
    public Optional<List<Usuarios_Areas>> findByAreaTrabajoId(Long id_Area_trabajo);
    
}
