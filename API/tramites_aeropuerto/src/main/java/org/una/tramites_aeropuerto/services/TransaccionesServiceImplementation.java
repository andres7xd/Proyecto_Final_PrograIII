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
import org.una.tramites_aeropuerto.dto.TransaccionesDTO;
import org.una.tramites_aeropuerto.entities.Transacciones;
import org.una.tramites_aeropuerto.repositories.ITransaccionesRepository;
import org.una.tramites_aeropuerto.utils.Convertir;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class TransaccionesServiceImplementation implements ITransaccionesService {
    
    @Autowired
    private ITransaccionesRepository transaccionesRepository;

    @Override
    public Optional<List<TransaccionesDTO>> findAll() {
        return (Optional<List<TransaccionesDTO>>) Convertir.findList(Optional.ofNullable(transaccionesRepository.findAll()), TransaccionesDTO.class);
    }

    @Override
    public TransaccionesDTO create(TransaccionesDTO transaccionesDTO) {
        Transacciones transacciones = MapperUtils.EntityFromDto(transaccionesDTO, Transacciones.class);
        transacciones = transaccionesRepository.save(transacciones);
        return MapperUtils.DtoFromEntity(transacciones, TransaccionesDTO.class);
    }

    @Override
    public Optional<TransaccionesDTO> update(TransaccionesDTO transaccionesDTO, Long id) {
        if (transaccionesRepository.findById(id).isPresent()) {
            Transacciones transacciones = MapperUtils.EntityFromDto(transaccionesDTO, Transacciones.class);
            transacciones = transaccionesRepository.save(transacciones);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(transacciones, TransaccionesDTO.class));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        transaccionesRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        transaccionesRepository.deleteAll();
    }

    @Override
    public Optional<TransaccionesDTO> findById(Long id) {
        return (Optional<TransaccionesDTO>) Convertir.oneToDto(transaccionesRepository.findById(id), TransaccionesDTO.class);
    }

}
