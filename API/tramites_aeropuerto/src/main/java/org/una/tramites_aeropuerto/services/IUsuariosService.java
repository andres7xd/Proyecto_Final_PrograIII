/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.AuthenticationRequest;
import org.una.tramites_aeropuerto.dto.AuthenticationResponse;
import org.una.tramites_aeropuerto.entities.Usuarios;

/**
 *
 * @author rache
 */
public interface IUsuariosService {

    public Optional<List<Usuarios>> findAll();

    public Optional<Usuarios> findById(Long id);

    public Optional<List<Usuarios>> findByCedulaAproximate(String cedula);

    public Optional<List<Usuarios>> findByCorreoAproximate(String correo);

    public Optional<List<Usuarios>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto);

    public AuthenticationResponse  login(AuthenticationRequest authenticationRequest);

    public Usuarios create(Usuarios usuario);

    public Optional<Usuarios> update(Usuarios usuario, Long id);

    public Optional<List<Usuarios>> findByRolesId(Long id);

    public Optional<List<Usuarios>> findByJefeId(Long id);

    public Optional<Usuarios> login(Usuarios usuario);

    public Optional<Usuarios> findByCedula(String cedula);

    public void delete(Long id);

    public void deleteAll();
}
