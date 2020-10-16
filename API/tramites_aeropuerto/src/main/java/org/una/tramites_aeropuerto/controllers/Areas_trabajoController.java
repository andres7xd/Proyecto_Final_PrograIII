/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites_aeropuerto.dto.Areas_trabajoDTO;
import org.una.tramites_aeropuerto.services.IAreas_trabajoService;

/**
 *
 * @author Luis
 */
@RestController
@RequestMapping("/areas_trabajo")
@Api(tags = {"Areas_trabajo"})

public class Areas_trabajoController {

    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @Autowired
    private IAreas_trabajoService areas_trabajoService;

    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Creacion de una área de trabajo:", response = Areas_trabajoDTO.class, tags = "Areas_trabajo")
    public ResponseEntity<?> create(@Valid @RequestBody Areas_trabajoDTO areas_trabajoDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(areas_trabajoService.create(areas_trabajoDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de áreas de trabajo:", response = Areas_trabajoDTO.class, tags = "Areas_trabajo")
     public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Areas_trabajoDTO areas_trabajoDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                Optional<Areas_trabajoDTO> areas_trabajoUpdated = areas_trabajoService.update(areas_trabajoDTO, id);
                if (areas_trabajoUpdated.isPresent()) {
                    return new ResponseEntity(areas_trabajoUpdated, HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las áreas de trabajo", response = Areas_trabajoDTO.class, responseContainer = "List", tags = "Areas_trabajo")
    public @ResponseBody
    ResponseEntity<?> findAll() {
         try {
            return new ResponseEntity<>(areas_trabajoService.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
         try {
            return new ResponseEntity(areas_trabajoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            areas_trabajoService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<?> deleteAll() {
        try {
            areas_trabajoService.deleteAll();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
