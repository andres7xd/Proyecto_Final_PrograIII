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
import org.una.tramites_aeropuerto.dto.ParametrosDTO;
import org.una.tramites_aeropuerto.entities.Parametros;
import org.una.tramites_aeropuerto.repositories.IParametrosRepository;
import org.una.tramites_aeropuerto.utils.Convertir;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class ParametrosServiceImplementation implements IParametrosService{
 
     @Autowired
    private IParametrosRepository parametrosRepository;

    @Override
    public Optional<List<ParametrosDTO>> findAll() {
        return (Optional<List<ParametrosDTO>>) Convertir.findList(Optional.ofNullable(parametrosRepository.findAll()), ParametrosDTO.class);
    }

    @Override
    public ParametrosDTO create(ParametrosDTO parametrosDTO) {
        Parametros parametros = MapperUtils.EntityFromDto(parametrosDTO, Parametros.class);
        parametros = parametrosRepository.save(parametros);
        return MapperUtils.DtoFromEntity(parametros, ParametrosDTO.class);
    }

    @Override
    public Optional<ParametrosDTO> update(ParametrosDTO parametrosDTO, Long id) {
        if (parametrosRepository.findById(id).isPresent()) {
            Parametros parametros = MapperUtils.EntityFromDto(parametrosDTO, Parametros.class);
            parametros = parametrosRepository.save(parametros);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(parametros, ParametrosDTO.class));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        parametrosRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        parametrosRepository.deleteAll();
    }
}
