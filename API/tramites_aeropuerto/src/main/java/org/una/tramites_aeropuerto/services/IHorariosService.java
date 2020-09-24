/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.entities.Horarios;

/**
 *
 * @author Luis
 */
public interface IHorariosService {

    public Optional<List<Horarios>> findAll();

    public Optional<Horarios> findById(Long id);

    public Horarios create(Horarios horarios);

    public Optional<Horarios> update(Horarios horarios, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<List<Horarios>> findByUsuarioAreaId(Long id_Usuario_Area);

//    public Optional<List<Horarios>> findByDiaEntradaBetween(Date startDate2, Date endDate2);

    public Optional<List<Horarios>> findByDiaSalidaBetween(Date startDate, Date endDate);
}
