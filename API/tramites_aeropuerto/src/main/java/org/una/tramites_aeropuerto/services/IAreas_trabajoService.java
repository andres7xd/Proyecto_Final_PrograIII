/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.Areas_trabajoDTO;

/**
 *
 * @author Luis
 */
public interface IAreas_trabajoService {
    
   public Optional<List<Areas_trabajoDTO>> findAll();
    
    public Optional<Areas_trabajoDTO> findById(Long id);
    
    public Areas_trabajoDTO create(Areas_trabajoDTO areas_trabajoDTO);

    public Optional<Areas_trabajoDTO> update(Areas_trabajoDTO areas_trabajoDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
