/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.tramites_aeropuerto.entities.Usuarios_Areas;

/**
 *
 * @author Luis
 */
public interface IUsuarios_AreasRepository extends JpaRepository<Usuarios_Areas, Long> {
//    
//    @Query("SELECT u FROM Usuarios_Areas u WHERE u.usuarios = id_Usuario")
//    public List<Usuarios_Areas> findByUsuarioId(@Param("id_Usuario") Long id_Usuario);

    @Query("SELECT u FROM Usuarios_Areas u WHERE u.areas_trabajo = id_Area_trabajo")
    public List<Usuarios_Areas> findByAreaTrabajoId(@Param("id_Area_trabajo") Long id_Area_trabajo);
}
