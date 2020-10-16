/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.ImagenesDTO;

/**
 *
 * @author andre
 */
public interface IImagenesService {

        public Optional<List<ImagenesDTO>> findAll();

    public Optional<ImagenesDTO> findById(Long id);

    public ImagenesDTO create(ImagenesDTO imagenesDTO);

    public Optional<ImagenesDTO> update(ImagenesDTO imagenesDTO, Long id);
    
    public void delete(Long id);

    public void deleteAll();

}
