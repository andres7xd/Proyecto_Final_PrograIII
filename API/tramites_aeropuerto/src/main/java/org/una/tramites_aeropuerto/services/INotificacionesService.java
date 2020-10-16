/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.NotificacionesDTO;

/**
 *
 * @author andre
 */
public interface INotificacionesService {

    public Optional<List<NotificacionesDTO>> findAll();

    public Optional<NotificacionesDTO> findById(Long id);

    public NotificacionesDTO create(NotificacionesDTO notificacionesDTO);

    public Optional<NotificacionesDTO> update(NotificacionesDTO notificacionesDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
