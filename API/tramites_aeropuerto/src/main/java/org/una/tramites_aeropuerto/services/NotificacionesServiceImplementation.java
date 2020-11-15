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
import org.una.tramites_aeropuerto.dto.NotificacionesDTO;
import org.una.tramites_aeropuerto.entities.Notificaciones;
import org.una.tramites_aeropuerto.repositories.INotificacionesRepository;
import org.una.tramites_aeropuerto.utils.Convertir;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author andre
 */
@Service
public class NotificacionesServiceImplementation implements INotificacionesService {

    @Autowired
    private INotificacionesRepository notificacionesRepository;

    @Override
    @Transactional
    public NotificacionesDTO create(NotificacionesDTO notificacionesDTO) {
        Notificaciones notificaciones = MapperUtils.EntityFromDto(notificacionesDTO, Notificaciones.class);
        notificaciones = notificacionesRepository.save(notificaciones);
        return MapperUtils.DtoFromEntity(notificaciones, NotificacionesDTO.class);
    }

    @Override
    @Transactional
    public Optional<NotificacionesDTO> update(NotificacionesDTO notificacionesDTO, Long id) {
        if (notificacionesRepository.findById(id).isPresent()) {
            Notificaciones notificaciones = MapperUtils.EntityFromDto(notificacionesDTO, Notificaciones.class);
            notificaciones = notificacionesRepository.save(notificaciones);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(notificaciones, NotificacionesDTO.class));
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
    public Optional<NotificacionesDTO> findById(Long id) {
        return (Optional<NotificacionesDTO>) Convertir.oneToDto(notificacionesRepository.findById(id), NotificacionesDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<NotificacionesDTO>> findAll() {
        return (Optional<List<NotificacionesDTO>>) Convertir.findList(Optional.ofNullable(notificacionesRepository.findAll()), NotificacionesDTO.class);
    }
    
    @Override
    public Optional<List<NotificacionesDTO>> findByEmisorAproximate(String emisor) {
        return (Optional<List<NotificacionesDTO>>) Convertir.findList(Optional.ofNullable(notificacionesRepository.findByEmisorContaining(emisor)), NotificacionesDTO.class);
    }
}
