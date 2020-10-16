/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.Marcas_horarioDTO;

/**
 *
 * @author rache
 */
public interface IMarcas_horarioService {

 public Marcas_horarioDTO create(Marcas_horarioDTO marcas_horarioDTO);

    public Optional<List<Marcas_horarioDTO>> findAll();
    
    public Optional<Marcas_horarioDTO> findById(Long id);

    public Optional<Marcas_horarioDTO> update(Marcas_horarioDTO marcas_horarioDTO, Long id);

    public Optional<List<Marcas_horarioDTO>> findByHorarioBetween(Date startDate, Date endDate);

    public Optional<List<Marcas_horarioDTO>> findByHora_EntradaBetween(Date startDate, Date endDate);

    public Optional<List<Marcas_horarioDTO>> findByHora_SalidaBetween(Date startDate, Date endDate);

    public void delete(Long id);

    public void deleteAll();

}
