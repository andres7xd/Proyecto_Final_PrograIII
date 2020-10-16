/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.HorariosDTO;

/**
 *
 * @author Luis
 */
public interface IHorariosService {

    public Optional<List<HorariosDTO>> findAll();

    public Optional<HorariosDTO> findById(Long id);

    public HorariosDTO create(HorariosDTO horariosDTO);

    public Optional<HorariosDTO> update(HorariosDTO horariosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
