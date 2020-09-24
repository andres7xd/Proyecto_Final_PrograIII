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
import org.una.tramites_aeropuerto.dto.Areas_trabajoDto;
import org.una.tramites_aeropuerto.dto.HorariosDTO;
import org.una.tramites_aeropuerto.entities.Areas_trabajo;
import org.una.tramites_aeropuerto.entities.Horarios;
import org.una.tramites_aeropuerto.services.IHorariosService;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@RestController
@RequestMapping("/horarios")
@Api(tags = {"Horarios"})

public class HorariosController {
    @Autowired
    private IHorariosService horariosService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Creacion de una área de un horario:", response = HorariosDTO.class, tags = "Horarios")
    public ResponseEntity<?> create(@RequestBody Horarios horarios) {
        try {
            Horarios horariosCreated = horariosService.create(horarios);
            HorariosDTO horariosDTO = MapperUtils.DtoFromEntity(horariosCreated, HorariosDTO.class);
            return new ResponseEntity<>(horariosDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de horarios:", response = HorariosDTO.class, tags = "Horarios")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Horarios horariosModified) {
        try {
            Optional<Horarios> horariosUpdated = horariosService.update(horariosModified, id);
            if (horariosUpdated.isPresent()) {
                HorariosDTO horariosDTO = MapperUtils.DtoFromEntity(horariosUpdated.get(), HorariosDTO.class);
                return new ResponseEntity<>(horariosDTO, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los horarios", response = HorariosDTO.class, responseContainer = "List", tags = "Horarios")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Horarios>> result = horariosService.findAll();
            if (result.isPresent()) {
                List<HorariosDTO> horariosDTO = MapperUtils.DtoListFromEntityList(result.get(), HorariosDTO.class);
                return new ResponseEntity<>(horariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Horarios> horarios = horariosService.findById(id);
            if (horarios.isPresent()) {
                HorariosDTO horariosDTO = MapperUtils.DtoFromEntity(horarios.get(), HorariosDTO.class);
                return new ResponseEntity<>(horariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
