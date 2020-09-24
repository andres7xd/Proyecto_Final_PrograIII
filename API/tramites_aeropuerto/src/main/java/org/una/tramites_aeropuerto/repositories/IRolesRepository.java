/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites_aeropuerto.entities.Roles;

/**
 *
 * @author rache
 */
public interface IRolesRepository extends JpaRepository<Roles, Long> {

    public List<Roles> findAll();

    public Roles findByNombreContainingIgnoreCase(String nombre);

}
