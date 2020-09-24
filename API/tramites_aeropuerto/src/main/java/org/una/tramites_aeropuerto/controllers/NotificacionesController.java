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
import org.una.tramites_aeropuerto.dto.NotificacionesDTO;
import org.una.tramites_aeropuerto.dto.UsuariosDTO;
import org.una.tramites_aeropuerto.entities.Notificaciones;
import org.una.tramites_aeropuerto.services.INotificacionesService;
import org.una.tramites_aeropuerto.utils.MapperUtils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/notificaciones")
@Api(tags = {"Notificaciones"})
public class NotificacionesController {
    
    @Autowired
    private INotificacionesService notificacionesService;
    
     ResponseEntity<?> findAll() {
        try {
            Optional<List<Notificaciones>> result = notificacionesService.findAll();
            if (result.isPresent()) {
                List<NotificacionesDTO> notificacionesDTO = MapperUtils.DtoListFromEntityList(result.get(), NotificacionesDTO.class);
                return new ResponseEntity<>(notificacionesDTO, HttpStatus.OK);
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

            Optional<Notificaciones> usuarioFound = notificacionesService.findById(id);
            if (usuarioFound.isPresent()) {
                NotificacionesDTO notificacionesDTO = MapperUtils.DtoFromEntity(usuarioFound.get(), NotificacionesDTO.class);
                return new ResponseEntity<>(notificacionesDTO, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de Notificaciones:", response = NotificacionesDTO.class, tags = "Notificaciones")
    public ResponseEntity<?> create(@RequestBody Notificaciones notificaciones) {
        try {
            Notificaciones usuarioCreated = notificacionesService.create(notificaciones);
            NotificacionesDTO notificacionesDto = MapperUtils.DtoFromEntity(usuarioCreated, NotificacionesDTO.class);
            return new ResponseEntity<>(notificacionesDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de Notificaciones:", response = UsuariosDTO.class, tags = "Notificaciones")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Notificaciones usuarioModified) {
        try {
            Optional<Notificaciones> notificacionesUpdated = notificacionesService.update(usuarioModified, id);
            if (notificacionesUpdated.isPresent()) {
                NotificacionesDTO notificacionesDto = MapperUtils.DtoFromEntity(notificacionesUpdated.get(), NotificacionesDTO.class);
                return new ResponseEntity<>(notificacionesDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("/emisor/{term}") 
    public ResponseEntity<?> findByEmisor(@PathVariable(value = "emisor")String term) {
        try {

            Optional<Notificaciones> permisoFound = notificacionesService.findByEmisor(term);
            if (permisoFound.isPresent()) {
                NotificacionesDTO notificacionesDto = MapperUtils.DtoFromEntity(permisoFound.get(), NotificacionesDTO.class);
                return new ResponseEntity<>(notificacionesDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
  
}
