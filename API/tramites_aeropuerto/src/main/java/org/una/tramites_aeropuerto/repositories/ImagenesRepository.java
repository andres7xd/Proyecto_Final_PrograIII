/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.una.tramites_aeropuerto.entities.Imagenes;

/**
 *
 * @author andre
 */
public interface ImagenesRepository extends JpaRepository<Imagenes, Long> {

//    @Query("SELECT u FROM Imagenes u WHERE u.Notificaciones = notificaciones_id")
    public List<Imagenes> findByNotificacionesId(Long id);
}
