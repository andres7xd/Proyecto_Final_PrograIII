/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.tramites_aeropuerto.entities.Marcas_horario;
import org.una.tramites_aeropuerto.repositories.IMarcas_horarioRepository;

/**
 *
 * @author rache
 */
@Service
public class Marcas_horarioServiceImplementation implements IMarcas_horarioService {

    @Autowired
    private IMarcas_horarioRepository marcas_horarioRepository;

    @Override
    public Optional<List<Marcas_horario>> findByHorarioBetween(Date startDate, Date endDate) {
        return Optional.ofNullable(marcas_horarioRepository.findByHorarioBetween(startDate, endDate));
    }

    @Override
    public Optional<List<Marcas_horario>> findByHora_EntradaBetween(Date startDate, Date endDate) {
        return Optional.ofNullable(marcas_horarioRepository.findByHora_EntradaBetween(startDate, endDate));
    }

    @Override
    public Optional<List<Marcas_horario>> findByHora_SalidaBetween(Date startDate, Date endDate) {
        return Optional.ofNullable(marcas_horarioRepository.findByHora_SalidaBetween(startDate, endDate));
    }

    @Override
    public Marcas_horario create(Marcas_horario marcaHorario) {
        return marcas_horarioRepository.save(marcaHorario);
    }

    @Override
    public Optional<List<Marcas_horario>> findAll() {
        return Optional.ofNullable(marcas_horarioRepository.findAll());
    }

    @Override
    public Optional<Marcas_horario> update(Marcas_horario marcaHorario, Long id) {
        if (marcas_horarioRepository.findById(id).isPresent()) {
            return Optional.ofNullable(marcas_horarioRepository.save(marcaHorario));
        } else {
            return null;
        }
    }

}
