/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.tramites_aeropuerto.entities.Marcas_horario;

/**
 *
 * @author rache
 */
public interface IMarcas_horarioRepository extends JpaRepository<Marcas_horario, Long> {

//    @Query("SELECT u FROM Marcas_horario u   WHERE  u.Horario BETWEEN starDate AND endDate ")
//    public List<Marcas_horario> findByHorarioBetween(@Param("starDate") Date startDate, @Param("endDate") Date endDate);
//
//    @Query("SELECT u FROM Marcas_horario u   WHERE  u.Hora_Entrada BETWEEN starDate AND endDate ")
//    public List<Marcas_horario> findByHora_EntradaBetween(@Param("starDate") Date startDate, @Param("endDate") Date endDate);
//
//    @Query("SELECT u FROM Marcas_horario u   WHERE  u.Hora_Salida BETWEEN starDate AND endDate ")
//    public List<Marcas_horario> findByHora_SalidaBetween(@Param("starDate") Date startDate, @Param("endDate") Date endDate);
}
