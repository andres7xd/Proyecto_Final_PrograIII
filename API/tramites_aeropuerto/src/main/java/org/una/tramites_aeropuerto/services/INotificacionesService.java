/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.entities.Notificaciones;

/**
 *
 * @author andre
 */
public interface INotificacionesService {
    
    public Optional<List<Notificaciones>> findAll();

    public Optional<Notificaciones> findById(Long id);

    public Notificaciones create(Notificaciones notificaciones);

    public Optional<Notificaciones> update(Notificaciones departamento, Long id);

    public void delete(Long id);

    public void deleteAll();
    
    public Optional<List<Notificaciones>> findByEstadoAproximate(boolean estado);
    
    public Optional<List<Notificaciones>> findByEmisorAproximate(String emisor);
    
}
