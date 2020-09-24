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
import org.una.tramites_aeropuerto.entities.Areas_trabajo;
import org.una.tramites_aeropuerto.services.IAreas_trabajoService;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@RestController
@RequestMapping("/areas_trabajo")
@Api(tags = {"Areas_trabajo"})

public class Areas_trabajoController {

    @Autowired
    private IAreas_trabajoService areas_trabajoService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Creacion de una área de trabajo:", response = Areas_trabajoDto.class, tags = "Areas_trabajo")
    public ResponseEntity<?> create(@RequestBody Areas_trabajo areas_trabajo) {
        try {
            Areas_trabajo areas_trabajoCreated = areas_trabajoService.create(areas_trabajo);
            Areas_trabajoDto areas_trabajoDto = MapperUtils.DtoFromEntity(areas_trabajoCreated, Areas_trabajoDto.class);
            return new ResponseEntity<>(areas_trabajoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de áreas de trabajo:", response = Areas_trabajoDto.class, tags = "Areas_trabajo")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Areas_trabajo areas_trabajoModified) {
        try {
            Optional<Areas_trabajo> areas_trabajoUpdated = areas_trabajoService.update(areas_trabajoModified, id);
            if (areas_trabajoUpdated.isPresent()) {
                Areas_trabajoDto areas_trabajoDto = MapperUtils.DtoFromEntity(areas_trabajoUpdated.get(), Areas_trabajoDto.class);
                return new ResponseEntity<>(areas_trabajoDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las áreas de trabajo", response = Areas_trabajoDto.class, responseContainer = "List", tags = "Areas_trabajo")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Areas_trabajo>> result = areas_trabajoService.findAll();
            if (result.isPresent()) {
                List<Areas_trabajoDto> areas_trabajoDto = MapperUtils.DtoListFromEntityList(result.get(), Areas_trabajoDto.class);
                return new ResponseEntity<>(areas_trabajoDto, HttpStatus.OK);
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

            Optional<Areas_trabajo> areas_trabajo = areas_trabajoService.findById(id);
            if (areas_trabajo.isPresent()) {
                Areas_trabajoDto areas_trabajoDto = MapperUtils.DtoFromEntity(areas_trabajo.get(), Areas_trabajoDto.class);
                return new ResponseEntity<>(areas_trabajoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
     @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> findByNombreAproximateIgnoreCase(@PathVariable(value = "nombre") String nombre) {
        try {
            Optional<List<Areas_trabajo>> result = areas_trabajoService.findByNombreAproximateIgnoreCase(nombre);
            if (result.isPresent()) {
                List<Areas_trabajoDto> areas_trabajoDto = MapperUtils.DtoListFromEntityList(result.get(), Areas_trabajoDto.class);
                return new ResponseEntity<>(areas_trabajoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
