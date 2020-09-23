/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites_aeropuerto.entities.Notificaciones;

/**
 *
 * @author andre
 */
public interface INotificacionesRepository extends JpaRepository<Notificaciones, Long> {
    
//     @Query("SELECT u FROM Notificaciones u  JOIN u.usuarios v WHERE v.usuarios = usuarios_id  AND u.fechaRegistro BETWEEN starDate AND endDate ")
//    public List<Notificaciones> findByUsuarioIdAndFechaEnvioBetween(@Param("usuarios_id") Long usuarioId, @Param("starDate") Date startDate, @Param("endDate") Date endDate);
//    
//    @Query("SELECT u FROM Notificaciones u  JOIN u.usuarios v WHERE v.usuarios = usuarios_id  AND u.fechaRegistro BETWEEN starDate AND endDate ")
//    public List<Notificaciones> findByUsuarioIdAndFechaLecturaBetween(@Param("usuarios_id") Long usuarioId, @Param("starDate") Date startDate, @Param("endDate") Date endDate);
//    
            public Notificaciones findByEmisor(String emisor);
            
//    
//        public List<Notificaciones> findByEmisorContainingIgnoreCase(String emisor);
}
