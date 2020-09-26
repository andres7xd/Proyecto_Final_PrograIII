/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites_aeropuerto.entities.Notificaciones;
import org.una.tramites_aeropuerto.repositories.INotificacionesRepository;

/**
 *
 * @author andre
 */
@Service
public class NotificacionesServiceImplementation implements  INotificacionesService{
    
     @Autowired
    private INotificacionesRepository notificacionesRepository;
    
     @Override
    @Transactional
    public Notificaciones create(Notificaciones notificaciones) {
        return notificacionesRepository.save(notificaciones);
    }

    @Override
    @Transactional
    public Optional<Notificaciones> update(Notificaciones notificaciones, Long id) {
        if (notificacionesRepository.findById(id).isPresent()) {
            return Optional.ofNullable(notificacionesRepository.save(notificaciones));
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
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Notificaciones>> findAll() {
        return Optional.ofNullable(notificacionesRepository.findAll());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Notificaciones> findByEmisor(String emisor) {
        return Optional.ofNullable(notificacionesRepository.findByEmisor(emisor));
    }
}
