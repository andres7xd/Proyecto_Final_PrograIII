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
import org.una.tramites_aeropuerto.dto.ImagenesDTO;
import org.una.tramites_aeropuerto.entities.Imagenes;
import org.una.tramites_aeropuerto.repositories.ImagenesRepository;
import org.una.tramites_aeropuerto.utils.Convertir;
import org.una.tramites_aeropuerto.utils.MapperUtils;


/**
 *
 * @author andre
 */
@Service
public class ImagenesServiceImplementation implements IImagenesService {
    
    
   @Autowired
    private ImagenesRepository imagenesRepository;

    @Override
    @Transactional
    public ImagenesDTO create(ImagenesDTO imagenesDTO) {
        Imagenes imagenes = MapperUtils.EntityFromDto(imagenesDTO, Imagenes.class);
        imagenes = imagenesRepository.save(imagenes);
        return MapperUtils.DtoFromEntity(imagenes, ImagenesDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ImagenesDTO> findById(Long id) {

        return (Optional<ImagenesDTO>) Convertir.oneToDto(imagenesRepository.findById(id), ImagenesDTO.class);
    }

    @Override
    @Transactional
    public Optional<ImagenesDTO> update(ImagenesDTO imagenesDTO, Long id) {
        if (imagenesRepository.findById(id).isPresent()) {
            Imagenes imagenes = MapperUtils.EntityFromDto(imagenesDTO, Imagenes.class);
            imagenes = imagenesRepository.save(imagenes);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(imagenes, ImagenesDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        imagenesRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        imagenesRepository.deleteAll();
    }

    @Override
    public Optional<List<ImagenesDTO>> findAll() {
        return (Optional<List<ImagenesDTO>>) Convertir.findList(Optional.ofNullable(imagenesRepository.findAll()), ImagenesDTO.class);
    }

}
