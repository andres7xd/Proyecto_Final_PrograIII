/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites_aeropuerto.dto.Marcas_horarioDTO;
import org.una.tramites_aeropuerto.entities.Marcas_horario;
import org.una.tramites_aeropuerto.services.IMarcas_horarioService;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author rache
 */
@RestController
@RequestMapping("/marcas_horario")
@Api(tags = {"Marcas_horario"})
public class Marcas_horarioController {

    @Autowired
    private IMarcas_horarioService marca_horarioService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Creacion de una Marca:", response = Marcas_horarioDTO.class, tags = "Marcas_horario")
    public ResponseEntity<?> create(@RequestBody Marcas_horario marcaHorario) {
        try {
            Marcas_horario marcaHorarioCreated = marca_horarioService.create(marcaHorario);
            Marcas_horarioDTO marca_horarioDTO = MapperUtils.DtoFromEntity(marcaHorarioCreated, Marcas_horarioDTO.class);
            return new ResponseEntity<>(marca_horarioDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de marcas:", response = Marcas_horarioDTO.class, tags = "Marcas_horario")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Marcas_horario marcas_horarioModified) {
        try {
            Optional<Marcas_horario> marcas_horarioUpdated = marca_horarioService.update(marcas_horarioModified, id);
            if (marcas_horarioUpdated.isPresent()) {
                Marcas_horarioDTO marcas_horariosDTO = MapperUtils.DtoFromEntity(marcas_horarioUpdated.get(), Marcas_horarioDTO.class);
                return new ResponseEntity<>(marcas_horariosDTO, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las Marcas", response = Marcas_horarioDTO.class, responseContainer = "List", tags = "Marcas_horario")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Marcas_horario>> result = marca_horarioService.findAll();
            if (result.isPresent()) {
                List<Marcas_horarioDTO> marcas_horariosDTO = MapperUtils.DtoListFromEntityList(result.get(), Marcas_horarioDTO.class);
                return new ResponseEntity<>(marcas_horariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
