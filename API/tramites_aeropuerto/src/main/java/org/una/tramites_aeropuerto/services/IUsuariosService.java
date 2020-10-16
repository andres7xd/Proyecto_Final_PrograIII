/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.UsuariosDTO;

/**
 *
 * @author rache
 */
public interface IUsuariosService {

    public Optional<List<UsuariosDTO>> findAll();

    public Optional<UsuariosDTO> findById(Long id);

    public Optional<List<UsuariosDTO>> findByCedulaAproximate(String cedula);

    public Optional<List<UsuariosDTO>> findByCorreoAproximate(String correo);

    public Optional<List<UsuariosDTO>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto);

    public UsuariosDTO create(UsuariosDTO usuariosDTO);

    public Optional<UsuariosDTO> update(UsuariosDTO usuariosDTO, Long id);

    public Optional<List<UsuariosDTO>> findByRolesId(Long id);

    public Optional<List<UsuariosDTO>> findByEmpleadoId(Long id);

    public Optional<UsuariosDTO> findByCedula(String cedula);

    public void delete(Long id);

    public void deleteAll();
}
