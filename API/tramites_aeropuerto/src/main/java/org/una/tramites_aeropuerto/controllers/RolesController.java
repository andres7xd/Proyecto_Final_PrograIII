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
import org.una.tramites_aeropuerto.dto.RolesDTO;
import org.una.tramites_aeropuerto.entities.Roles;
import org.una.tramites_aeropuerto.services.IRolesService;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author rache
 */
@RestController
@RequestMapping("/roles")
@Api(tags = {"Roles"})
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Roles", response = RolesDTO.class, responseContainer = "List", tags = "Roles")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Roles>> result = rolesService.findAll();
            if (result.isPresent()) {
                List<RolesDTO> RolesDTO = MapperUtils.DtoListFromEntityList(result.get(), RolesDTO.class);
                return new ResponseEntity<>(RolesDTO, HttpStatus.OK);
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

            Optional<Roles> rol = rolesService.findById(id);
            if (rol.isPresent()) {
                RolesDTO rolesDTO = MapperUtils.DtoFromEntity(rol.get(), RolesDTO.class);
                return new ResponseEntity<>(rolesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String nombre) {
        try {

            Optional<Roles> rol = rolesService.findByNombreAproximateIgnoreCase(nombre);
            if (rol.isPresent()) {
                RolesDTO rolesDTO = MapperUtils.DtoFromEntity(rol.get(), RolesDTO.class);
                return new ResponseEntity<>(rolesDTO, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de un Rol:", response = RolesDTO.class, tags = "Roles")
    public ResponseEntity<?> create(@RequestBody Roles roles) {
        try {
            Roles rolesCreated = rolesService.create(roles);
            RolesDTO usuarioDto = MapperUtils.DtoFromEntity(rolesCreated, RolesDTO.class);
            return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de un Rol:", response = RolesDTO.class, tags = "Roles")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Roles rolModified) {
        try {
            Optional<Roles> rolUpdated = rolesService.update(rolModified, id);
            if (rolUpdated.isPresent()) {
                RolesDTO rolesDto = MapperUtils.DtoFromEntity(rolUpdated.get(), RolesDTO.class);
                return new ResponseEntity<>(rolesDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
