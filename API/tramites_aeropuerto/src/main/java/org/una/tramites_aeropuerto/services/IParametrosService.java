/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.ParametrosDTO;

/**
 *
 * @author Luis
 */
public interface IParametrosService {
    
    public Optional<List<ParametrosDTO>> findAll();

    public ParametrosDTO create(ParametrosDTO parametrosDTO);

    public Optional<ParametrosDTO> update(ParametrosDTO parametrosDTO, Long id);

    public void delete(Long id);
    
    public void deleteAll();
}
