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
import org.una.tramites_aeropuerto.dto.Areas_trabajoDTO;
import org.una.tramites_aeropuerto.entities.Areas_trabajo;
import org.una.tramites_aeropuerto.repositories.IAreas_trabajoRepository;
import org.una.tramites_aeropuerto.utils.Convertir;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class Areas_trabajoServiceImplementation implements IAreas_trabajoService {

     @Autowired
    private IAreas_trabajoRepository areas_trabajoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Areas_trabajoDTO>> findAll() {
        return (Optional<List<Areas_trabajoDTO>>) Convertir.findList(Optional.ofNullable(areas_trabajoRepository.findAll()), Areas_trabajoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Areas_trabajoDTO> findById(Long id) {
         return (Optional<Areas_trabajoDTO>) Convertir.oneToDto(areas_trabajoRepository.findById(id), Areas_trabajoDTO.class);
    }

    @Override
    @Transactional
    public Areas_trabajoDTO create(Areas_trabajoDTO areas_trabajoDTO) {
        Areas_trabajo areas_trabajo = MapperUtils.EntityFromDto(areas_trabajoDTO, Areas_trabajo.class);
        areas_trabajo = areas_trabajoRepository.save(areas_trabajo);
        return MapperUtils.DtoFromEntity(areas_trabajo, Areas_trabajoDTO.class);
    }

    @Override
    @Transactional
    public Optional<Areas_trabajoDTO> update(Areas_trabajoDTO areas_trabajoDTO, Long id) {
       if (areas_trabajoRepository.findById(id).isPresent()) {
            Areas_trabajo areas_trabajo = MapperUtils.EntityFromDto(areas_trabajoDTO, Areas_trabajo.class);
            areas_trabajo = areas_trabajoRepository.save(areas_trabajo);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(areas_trabajo, Areas_trabajoDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        areas_trabajoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        areas_trabajoRepository.deleteAll();
    }

}
