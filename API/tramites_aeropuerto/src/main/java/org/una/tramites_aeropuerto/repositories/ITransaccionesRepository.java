/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites_aeropuerto.entities.Transacciones;

/**
 *
 * @author Luis
 */
public interface ITransaccionesRepository extends JpaRepository<Transacciones, Long>{
    
}
