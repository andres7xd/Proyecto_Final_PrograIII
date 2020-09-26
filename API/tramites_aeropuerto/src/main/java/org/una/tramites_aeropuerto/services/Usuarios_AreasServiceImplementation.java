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
import org.una.tramites_aeropuerto.entities.Usuarios_Areas;
import org.una.tramites_aeropuerto.repositories.IUsuarios_AreasRepository;

/**
 *
 * @author Luis
 */
@Service
public class Usuarios_AreasServiceImplementation implements IUsuarios_AreasService{
    
    @Autowired
    private IUsuarios_AreasRepository usuarios_areasRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuarios_Areas>> findAll() {
        return Optional.ofNullable(usuarios_areasRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuarios_Areas> findById(Long id) {
        return usuarios_areasRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuarios_Areas create(Usuarios_Areas usuarios_areas) {
        return usuarios_areasRepository.save(usuarios_areas);
    }

    @Override
    @Transactional
    public Optional<Usuarios_Areas> update(Usuarios_Areas usuarios_areas, Long id) {
        if (usuarios_areasRepository.findById(id).isPresent()) {
            return Optional.ofNullable(usuarios_areasRepository.save(usuarios_areas));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        usuarios_areasRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        usuarios_areasRepository.deleteAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuarios_Areas>> findByAreaTrabajoId(Long id_Area_trabajo){
        return Optional.ofNullable(usuarios_areasRepository.findByAreaTrabajoId(id_Area_trabajo));
    }
    
    
}
