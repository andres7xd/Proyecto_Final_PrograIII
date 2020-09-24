/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.entities.Roles;

/**
 *
 * @author rache
 */
public interface IRolesService {

    public Optional<List<Roles>> findAll();

    public Optional<Roles> findById(Long id);

    public Optional<Roles> findByNombreAproximateIgnoreCase(String nombre);

    public Roles create(Roles rol);

    public Optional<Roles> update(Roles rol, Long id);

    public void delete(Long id);

}
