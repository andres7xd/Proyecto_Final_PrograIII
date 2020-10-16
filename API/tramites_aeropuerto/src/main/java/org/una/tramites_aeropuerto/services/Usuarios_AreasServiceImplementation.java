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
import org.una.tramites_aeropuerto.dto.Usuarios_AreasDTO;
import org.una.tramites_aeropuerto.entities.Usuarios_Areas;
import org.una.tramites_aeropuerto.repositories.IUsuarios_AreasRepository;
import org.una.tramites_aeropuerto.utils.Convertir;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class Usuarios_AreasServiceImplementation implements IUsuarios_AreasService{
    
    @Autowired
    private IUsuarios_AreasRepository usuarios_areasRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuarios_AreasDTO>> findAll() {
        return (Optional<List<Usuarios_AreasDTO>>) Convertir.findList(Optional.ofNullable(usuarios_areasRepository.findAll()), Usuarios_AreasDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuarios_AreasDTO> findById(Long id) {
        return (Optional<Usuarios_AreasDTO>) Convertir.oneToDto(usuarios_areasRepository.findById(id), Usuarios_AreasDTO.class);
    }

    @Override
    @Transactional
    public Usuarios_AreasDTO create(Usuarios_AreasDTO Usuarios_AreasDTO) {
        Usuarios_Areas usuarios_Areas = MapperUtils.EntityFromDto(Usuarios_AreasDTO, Usuarios_Areas.class);
        usuarios_Areas = usuarios_areasRepository.save(usuarios_Areas);
        return MapperUtils.DtoFromEntity(usuarios_Areas, Usuarios_AreasDTO.class);
    }

    @Override
    @Transactional
    public Optional<Usuarios_AreasDTO> update(Usuarios_AreasDTO usuarios_AreasDTO, Long id) {
        if (usuarios_areasRepository.findById(id).isPresent()) {
            Usuarios_Areas usuarios_Areas = MapperUtils.EntityFromDto(usuarios_AreasDTO, Usuarios_Areas.class);
            usuarios_Areas = usuarios_areasRepository.save(usuarios_Areas);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(usuarios_Areas, Usuarios_AreasDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        usuarios_areasRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        usuarios_areasRepository.deleteAll();
    }
    
}
