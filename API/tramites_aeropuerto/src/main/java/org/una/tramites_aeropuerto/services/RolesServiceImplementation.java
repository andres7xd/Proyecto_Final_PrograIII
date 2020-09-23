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
import org.una.tramites_aeropuerto.entities.Roles;
import org.una.tramites_aeropuerto.repositories.IRolesRepository;

/**
 *
 * @author rache
 */
@Service
public class RolesServiceImplementation implements IRolesService {

    @Autowired
    private IRolesRepository rolesRepository;

    @Override
    public Optional<List<Roles>> findAll() {
        return Optional.ofNullable(rolesRepository.findAll());
    }


    @Override
    public Roles create(Roles rol) {
        return rolesRepository.save(rol);
    }

    @Override
    public Optional<Roles> update(Roles rol, Long id) {
        if (rolesRepository.findById(id).isPresent()) {
            return Optional.ofNullable(rolesRepository.save(rol));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public Optional<Roles> findById(Long id) {
        return rolesRepository.findById(id);
    }
 @Override
    public Optional<List<Roles>> findByNombreAproximateIgnoreCase(String nombre) {
        return Optional.ofNullable(rolesRepository.findByNombreContainingIgnoreCase(nombre));
    }

 
}
