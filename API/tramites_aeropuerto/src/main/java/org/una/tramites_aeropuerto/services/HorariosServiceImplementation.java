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
import org.una.tramites_aeropuerto.entities.Horarios;
import org.una.tramites_aeropuerto.repositories.IHorariosRepository;

/**
 *
 * @author Luis
 */
@Service
public class HorariosServiceImplementation implements IHorariosService {

    @Autowired
    private IHorariosRepository horariosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Horarios>> findAll() {
        return Optional.ofNullable(horariosRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Horarios> findById(Long id) {
        return horariosRepository.findById(id);
    }

    @Override
    @Transactional
    public Horarios create(Horarios horarios) {
        return horariosRepository.save(horarios);
    }

    @Override
    @Transactional
    public Optional<Horarios> update(Horarios horarios, Long id) {
        if (horariosRepository.findById(id).isPresent()) {
            return Optional.ofNullable(horariosRepository.save(horarios));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        horariosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        horariosRepository.deleteAll();
    }

}
