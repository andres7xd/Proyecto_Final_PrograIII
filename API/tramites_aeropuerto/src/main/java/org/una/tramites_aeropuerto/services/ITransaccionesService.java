/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.TransaccionesDTO;

/**
 *
 * @author Luis
 */
public interface ITransaccionesService {
    
    public Optional<List<TransaccionesDTO>> findAll();

    public Optional<TransaccionesDTO> findById(Long id);

    public TransaccionesDTO create(TransaccionesDTO transaccionesDTO);

    public Optional<TransaccionesDTO> update(TransaccionesDTO transaccionesDTO, Long id);

    public void delete(Long id);
    
    public void deleteAll();
}
