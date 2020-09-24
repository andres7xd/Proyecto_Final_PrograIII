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
import org.una.tramites_aeropuerto.dto.Usuarios_AreasDto;
import org.una.tramites_aeropuerto.entities.Areas_trabajo;
import org.una.tramites_aeropuerto.entities.Usuarios_Areas;
import org.una.tramites_aeropuerto.services.IAreas_trabajoService;
import org.una.tramites_aeropuerto.services.IUsuarios_AreasService;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author Luis
 */

@RestController
@RequestMapping("/usuarios_areas")
@Api(tags = {"Usuarios_Areas"})

public class Usuarios_AreasController {
    
    @Autowired
    private IUsuarios_AreasService usuarios_areasService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Creacion de una área de un usuario_area:", response = Areas_trabajoDto.class, tags = "Usuarios_Areas")
    public ResponseEntity<?> create(@RequestBody Usuarios_Areas usuarios_areas) {
        try {
            Usuarios_Areas usuarios_areasCreated = usuarios_areasService.create(usuarios_areas);
            Usuarios_AreasDto usuarios_areasDto = MapperUtils.DtoFromEntity(usuarios_areasCreated, Usuarios_AreasDto.class);
            return new ResponseEntity<>(usuarios_areasDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de áreas de un usuario_area:", response = Usuarios_AreasDto.class, tags = "Usuarios_Areas")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Usuarios_Areas usuarios_areasModified) {
        try {
            Optional<Usuarios_Areas> usuarios_areasUpdated = usuarios_areasService.update(usuarios_areasModified, id);
            if (usuarios_areasUpdated.isPresent()) {
                Usuarios_AreasDto usuarios_areasDto = MapperUtils.DtoFromEntity(usuarios_areasUpdated.get(), Usuarios_AreasDto.class);
                return new ResponseEntity<>(usuarios_areasDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas los usuarios_areas", response = Usuarios_AreasDto.class, responseContainer = "List", tags = "Usuarios_Areas")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Usuarios_Areas>> result = usuarios_areasService.findAll();
            if (result.isPresent()) {
                List<Usuarios_AreasDto> usuarios_areasDto = MapperUtils.DtoListFromEntityList(result.get(), Usuarios_AreasDto.class);
                return new ResponseEntity<>(usuarios_areasDto, HttpStatus.OK);
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

            Optional<Usuarios_Areas> usuarios_areas = usuarios_areasService.findById(id);
            if (usuarios_areas.isPresent()) {
                Usuarios_AreasDto usuarios_areasDto = MapperUtils.DtoFromEntity(usuarios_areas.get(), Usuarios_AreasDto.class);
                return new ResponseEntity<>(usuarios_areasDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
