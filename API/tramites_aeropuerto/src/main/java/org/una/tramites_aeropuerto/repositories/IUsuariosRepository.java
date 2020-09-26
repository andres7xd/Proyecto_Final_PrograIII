/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites_aeropuerto.entities.Usuarios;

/**
 *
 * @author rache
 */
public interface IUsuariosRepository extends JpaRepository<Usuarios, Long> {

    public Usuarios findByCedulaAndContrasenaEncriptada(String cedula, String contrasenaEncriptada);

    public List<Usuarios> findByCedulaContaining(String cedula);

    public List<Usuarios> findByCorreoContaining(String correo);

    public List<Usuarios> findByNombreCompletoContainingIgnoreCase(String nombreCompleto);

    public List<Usuarios> findByRolesId(Long id);

    public List<Usuarios> findByJefeId(Long id);

    public Usuarios findByCedula(String cedula);


}
