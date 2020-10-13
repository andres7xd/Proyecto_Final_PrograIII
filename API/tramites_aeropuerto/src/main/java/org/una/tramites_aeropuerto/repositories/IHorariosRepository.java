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
import org.una.tramites_aeropuerto.entities.Horarios;

/**
 *
 * @author Luis
 */
public interface IHorariosRepository extends JpaRepository<Horarios, Long>{
    
//    @Query("SELECT u FROM Horarios u   WHERE  u.Dia_Entrada BETWEEN starDate2 AND endDate2")
//    public List<Horarios> findByDiaEntradaBetween(@Param("starDate2") Date startDate, @Param("endDate2") Date endDate);
    
    @Query("SELECT u FROM Horarios u   WHERE  u.Dia_Salida BETWEEN starDate AND endDate")
    public List<Horarios> findByDiaSalidaBetween(@Param("starDate") Date startDate, @Param("endDate") Date endDate);

    
}
