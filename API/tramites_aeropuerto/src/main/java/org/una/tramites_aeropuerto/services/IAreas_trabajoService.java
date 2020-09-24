/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.entities.Areas_trabajo;

/**
 *
 * @author Luis
 */
public interface IAreas_trabajoService {
    
    public Optional<List<Areas_trabajo>> findAll();
    
    public Optional<Areas_trabajo> findById(Long id);
    
    public Areas_trabajo create(Areas_trabajo areas_trabajo);

    public Optional<Areas_trabajo> update(Areas_trabajo areas_trabajo, Long id);

    public void delete(Long id);

    public void deleteAll();
    
    public Optional<List<Areas_trabajo>> findByNombreAproximateIgnoreCase(String nombre);
}
