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
import org.una.tramites_aeropuerto.entities.Areas_trabajo;
import org.una.tramites_aeropuerto.repositories.IAreas_trabajoRepository;

/**
 *
 * @author Luis
 */
@Service
public class Areas_trabajoServiceImplementation implements IAreas_trabajoService {

    @Autowired
    private IAreas_trabajoRepository areas_trabajoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Areas_trabajo>> findAll() {
        return Optional.ofNullable(areas_trabajoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Areas_trabajo> findById(Long id) {
        return areas_trabajoRepository.findById(id);
    }

    @Override
    @Transactional
    public Areas_trabajo create(Areas_trabajo areas_trabajo) {
        return areas_trabajoRepository.save(areas_trabajo);
    }

    @Override
    @Transactional
    public Optional<Areas_trabajo> update(Areas_trabajo areas_trabajo, Long id) {
        if (areas_trabajoRepository.findById(id).isPresent()) {
            return Optional.ofNullable(areas_trabajoRepository.save(areas_trabajo));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        areas_trabajoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        areas_trabajoRepository.deleteAll();
    }

    @Override
    public Optional<List<Areas_trabajo>> findByNombreAproximateIgnoreCase(String nombre) {
        return Optional.ofNullable(areas_trabajoRepository.findByNombreContainingIgnoreCase(nombre));
    }

}
