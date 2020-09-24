/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites_aeropuerto.entities.Areas_trabajo;

/**
 *
 * @author Luis
 */
public interface IAreas_trabajoRepository extends JpaRepository<Areas_trabajo, Long>{
    
    public List<Areas_trabajo> findByNombreContainingIgnoreCase(String nombre);
    
}
