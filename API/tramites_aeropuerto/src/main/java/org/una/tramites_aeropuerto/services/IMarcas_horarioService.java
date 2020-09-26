/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.entities.Marcas_horario;

/**
 *
 * @author rache
 */
public interface IMarcas_horarioService {

    public Marcas_horario create(Marcas_horario marcaHorario);

    public Optional<List<Marcas_horario>> findAll();

    public Optional<Marcas_horario> update(Marcas_horario marcaHorario, Long id);

    public Optional<List<Marcas_horario>> findByHora_EntradaBetween(Date startDate, Date endDate);

    public Optional<List<Marcas_horario>> findByHora_SalidaBetween(Date startDate, Date endDate);

}
