/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
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

    public Optional<List<Usuarios>> findByNombreAproximateIgnoreCase(String nombre);

    public Optional<List<Usuarios>> findByApellidosAproximateIgnoreCase(String apellidos);

    public Usuarios create(Usuarios usuario);

    public Optional<Usuarios> update(Usuarios usuario, Long id);

    public Optional<List<Usuarios>> findByRolId(Long id);

    public Optional<List<Usuarios>> findByEmpleadoId(Long id);

    public Optional<Usuarios> login(Usuarios usuario);

    public Optional<Usuarios> findByCedula(String cedula);

    public void delete(Long id);

    public void deleteAll();
}
