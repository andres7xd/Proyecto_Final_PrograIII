/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites_aeropuerto.entities.Notificaciones;
import org.una.tramites_aeropuerto.repositories.NotificacionesRepository;

/**
 *
 * @author andre
 */
public class NotificacionesServiceImplementation implements  INotificacionesService{
    
     @Autowired
    private NotificacionesRepository notificacionesRepository;
    
     @Override
    @Transactional
    public Notificaciones create(Notificaciones permiso) {
        return notificacionesRepository.save(permiso);
    }

    @Override
    @Transactional
    public Optional<Notificaciones> update(Notificaciones permiso, Long id) {
        if (notificacionesRepository.findById(id).isPresent()) {
            return Optional.ofNullable(notificacionesRepository.save(permiso));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        notificacionesRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        notificacionesRepository.deleteAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Notificaciones> findById(Long id) {
        return notificacionesRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public Optional<List<Notificaciones>> findByEstadoAproximate(boolean estado) {
        return Optional.ofNullable(notificacionesRepository.findByEstadoContaining(estado));
    }
    
     @Override
    @Transactional(readOnly = true)
    public Optional<List<Notificaciones>> findByEmisorAproximate(String emisor) {
        return Optional.ofNullable(notificacionesRepository.findByEmisorContaining(emisor));
    }
    
     @Override
    @Transactional(readOnly = true)
    public Optional<List<Notificaciones>> findAll() {
        return Optional.ofNullable(notificacionesRepository.findAll());
    }
}
