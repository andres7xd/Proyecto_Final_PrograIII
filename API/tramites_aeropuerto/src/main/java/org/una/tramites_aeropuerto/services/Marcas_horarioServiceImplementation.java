/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites_aeropuerto.dto.Marcas_horarioDTO;
import org.una.tramites_aeropuerto.entities.Marcas_horario;
import org.una.tramites_aeropuerto.repositories.IMarcas_horarioRepository;
import org.una.tramites_aeropuerto.utils.Convertir;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class Marcas_horarioServiceImplementation implements IMarcas_horarioService {

   @Autowired
    private IMarcas_horarioRepository marcas_horarioRepository;

//    @Override
//    public Optional<List<Marcas_horarioDTO>> findByHorarioBetween(Date startDate, Date endDate) {
//        return (Optional<List<Marcas_horarioDTO>>) Convertir.findList(Optional.ofNullable(marcas_horarioRepository.findByHorarioBetween(startDate, endDate)), Marcas_horarioDTO.class);
//    }
//
//    @Override
//    public Optional<List<Marcas_horarioDTO>> findByHora_EntradaBetween(Date startDate, Date endDate) {
//        return (Optional<List<Marcas_horarioDTO>>) Convertir.findList(Optional.ofNullable(marcas_horarioRepository.findByHora_EntradaBetween(startDate, endDate)), Marcas_horarioDTO.class);
//    }
//
//    @Override
//    public Optional<List<Marcas_horarioDTO>> findByHora_SalidaBetween(Date startDate, Date endDate) {
//        return (Optional<List<Marcas_horarioDTO>>) Convertir.findList(Optional.ofNullable(marcas_horarioRepository.findByHora_SalidaBetween(startDate, endDate)), Marcas_horarioDTO.class);
//    }

    @Override
    public Marcas_horarioDTO create(Marcas_horarioDTO marcas_horarioDTO) {
        Marcas_horario marcas_horario = MapperUtils.EntityFromDto(marcas_horarioDTO, Marcas_horario.class);
        marcas_horario = marcas_horarioRepository.save(marcas_horario);
        return MapperUtils.DtoFromEntity(marcas_horario, Marcas_horarioDTO.class);
    }

    @Override
    public Optional<List<Marcas_horarioDTO>> findAll() {
        return (Optional<List<Marcas_horarioDTO>>) Convertir.findList(Optional.ofNullable(marcas_horarioRepository.findAll()), Marcas_horarioDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Marcas_horarioDTO> findById(Long id) {

        return (Optional<Marcas_horarioDTO>) Convertir.oneToDto(marcas_horarioRepository.findById(id), Marcas_horarioDTO.class);
    }

    @Override
    public Optional<Marcas_horarioDTO> update(Marcas_horarioDTO marcas_horarioDTO, Long id) {
        if (marcas_horarioRepository.findById(id).isPresent()) {
            Marcas_horario marcas_horario = MapperUtils.EntityFromDto(marcas_horarioDTO, Marcas_horario.class);
            marcas_horario = marcas_horarioRepository.save(marcas_horario);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(marcas_horario, Marcas_horarioDTO.class));
        } else {
            return null;
        }
    }
    
    @Override
    @Transactional
    public void delete(Long id) {

        marcas_horarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        marcas_horarioRepository.deleteAll();
    }

}
