/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.RolesDTO;
/**
 *
 * @author rache
 */
public interface IRolesService {

    public Optional<List<RolesDTO>> findAll();

    public Optional<RolesDTO> findById(Long id);

    public Optional<RolesDTO> findByNombreAproximateIgnoreCase(String nombre);

    public RolesDTO create(RolesDTO rolesDTO);

    public Optional<RolesDTO> update(RolesDTO rolesDTO, Long id);

    public void delete(Long id);
    
    public void deleteAll();

}
