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
import org.una.tramites_aeropuerto.dto.RolesDTO;
import org.una.tramites_aeropuerto.entities.Roles;
import org.una.tramites_aeropuerto.repositories.IRolesRepository;
import org.una.tramites_aeropuerto.utils.Convertir;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class RolesServiceImplementation implements IRolesService {

    @Autowired
    private IRolesRepository rolesRepository;

    @Override
    public Optional<List<RolesDTO>> findAll() {
        return (Optional<List<RolesDTO>>) Convertir.findList(Optional.ofNullable(rolesRepository.findAll()), RolesDTO.class);
    }

    @Override
    public RolesDTO create(RolesDTO rolesDTO) {
        Roles roles = MapperUtils.EntityFromDto(rolesDTO, Roles.class);
        roles = rolesRepository.save(roles);
        return MapperUtils.DtoFromEntity(roles, RolesDTO.class);
    }

    @Override
    public Optional<RolesDTO> update(RolesDTO rolesDTO, Long id) {
        if (rolesRepository.findById(id).isPresent()) {
            Roles roles = MapperUtils.EntityFromDto(rolesDTO, Roles.class);
            roles = rolesRepository.save(roles);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(roles, RolesDTO.class));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        rolesRepository.deleteAll();
    }

    @Override
    public Optional<RolesDTO> findById(Long id) {
        return (Optional<RolesDTO>) Convertir.oneToDto(rolesRepository.findById(id), RolesDTO.class);
    }

    @Override
    public Optional<RolesDTO> findByNombreAproximateIgnoreCase(String nombre) {
        return (Optional<RolesDTO>) Convertir.oneToDto(Optional.ofNullable(rolesRepository.findByNombreContainingIgnoreCase(nombre)), RolesDTO.class);
    }

}
