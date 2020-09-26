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
import org.una.tramites_aeropuerto.dto.ImagenesDTO;
import org.una.tramites_aeropuerto.dto.NotificacionesDTO;
import org.una.tramites_aeropuerto.entities.Imagenes;
import org.una.tramites_aeropuerto.services.IImagenesService;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/imagenes")
@Api(tags = {"Imagenes"})
public class ImagenesController {
    @Autowired
    private IImagenesService imagenesService;
    
     ResponseEntity<?> findAll() {
        try {
            Optional<List<Imagenes>> result = imagenesService.findAll();
            if (result.isPresent()) {
                List<ImagenesDTO> imagenesDTO = MapperUtils.DtoListFromEntityList(result.get(), ImagenesDTO.class);
                return new ResponseEntity<>(imagenesDTO, HttpStatus.OK);
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

            Optional<Imagenes> usuarioFound = imagenesService.findById(id);
            if (usuarioFound.isPresent()) {
                ImagenesDTO imagenesDTO = MapperUtils.DtoFromEntity(usuarioFound.get(), ImagenesDTO.class);
                return new ResponseEntity<>(imagenesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Creacion de Imagenes:", response = NotificacionesDTO.class, tags = "Imagenes")
    public ResponseEntity<?> create(@RequestBody Imagenes imagenes) {
        try {
            Imagenes imagenesCreated = imagenesService.create(imagenes);
            NotificacionesDTO notificacionesDto = MapperUtils.DtoFromEntity(imagenesCreated, NotificacionesDTO.class);
            return new ResponseEntity<>(notificacionesDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de Imagenes:", response = ImagenesDTO.class, tags = "Imagenes")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Imagenes imagenesModified) {
        try {
            Optional<Imagenes> imagenesUpdated = imagenesService.update(imagenesModified, id);
            if (imagenesUpdated.isPresent()) {
                ImagenesDTO imagenesDto = MapperUtils.DtoFromEntity(imagenesUpdated.get(), ImagenesDTO.class);
                return new ResponseEntity<>(imagenesDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
