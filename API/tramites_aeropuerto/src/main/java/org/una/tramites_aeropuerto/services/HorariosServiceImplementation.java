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
import org.una.tramites_aeropuerto.dto.HorariosDTO;
import org.una.tramites_aeropuerto.entities.Horarios;
import org.una.tramites_aeropuerto.repositories.IHorariosRepository;
import org.una.tramites_aeropuerto.utils.Convertir;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class HorariosServiceImplementation implements IHorariosService {

   @Autowired
    private IHorariosRepository horariosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<HorariosDTO>> findAll() {
        return (Optional<List<HorariosDTO>>) Convertir.findList(Optional.ofNullable(horariosRepository.findAll()), HorariosDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<HorariosDTO> findById(Long id) {
        return (Optional<HorariosDTO>) Convertir.oneToDto(horariosRepository.findById(id), HorariosDTO.class);
    }

    @Override
    @Transactional
    public HorariosDTO create(HorariosDTO horariosDTO) {
        Horarios horarios = MapperUtils.EntityFromDto(horariosDTO, Horarios.class);
        horarios = horariosRepository.save(horarios);
        return MapperUtils.DtoFromEntity(horarios, HorariosDTO.class);
    }

    @Override
    @Transactional
    public Optional<HorariosDTO> update(HorariosDTO horariosDTO, Long id) {
        if (horariosRepository.findById(id).isPresent()) {
            Horarios horarios = MapperUtils.EntityFromDto(horariosDTO, Horarios.class);
            horarios = horariosRepository.save(horarios);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(horarios, HorariosDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        horariosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        horariosRepository.deleteAll();
    }
    
    public Optional<HorariosDTO> findByDiaEntradaContaining(String diaEntrada) {
        return (Optional<HorariosDTO>) Convertir.oneToDto(Optional.ofNullable(horariosRepository.findByDiaEntradaContaining(diaEntrada)), HorariosDTO.class);
    }
    
    public Optional<HorariosDTO> findByDiaSalidaContaining(String diaSalida) {
        return (Optional<HorariosDTO>) Convertir.oneToDto(Optional.ofNullable(horariosRepository.findByDiaEntradaContaining(diaSalida)), HorariosDTO.class);
    }
}
