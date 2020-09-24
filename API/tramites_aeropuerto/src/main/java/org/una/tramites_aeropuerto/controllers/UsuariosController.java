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
import org.una.tramites_aeropuerto.dto.UsuariosDTO;
import org.una.tramites_aeropuerto.entities.Usuarios;
import org.una.tramites_aeropuerto.services.IUsuariosService;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author rache
 */
@RestController
@RequestMapping("/usuarios")
@Api(tags = {"Usuarios"})
public class UsuariosController {

    @Autowired
    private IUsuariosService usuarioService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Usuarios", response = UsuariosDTO.class, responseContainer = "List", tags = "Usuarios")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Usuarios>> result = usuarioService.findAll();
            if (result.isPresent()) {
                List<UsuariosDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuariosDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
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

            Optional<Usuarios> usuarioFound = usuarioService.findById(id);
            if (usuarioFound.isPresent()) {
                UsuariosDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioFound.get(), UsuariosDTO.class);
                return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/login")
//    @ResponseBody
//    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = UsuariosDTO.class, tags = "Seguridad")
//    public ResponseEntity<?> login(@Valid @RequestBody AuthenticationRequest authenticationRequest, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity("La información no esta bien formada o no coincide con el formato esperado", HttpStatus.BAD_REQUEST);
//        }
//        try {
//            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
//            String token = usuarioService.login(authenticationRequest);
//            if (!token.isBlank()) {
//                authenticationResponse.setJwt(token);
//                //TODO: Complete this   authenticationResponse.setUsuario(usuario);
//                // TODO: Complete this    authenticationResponse.setPermisos(permisosOtorgados);
//                return new ResponseEntity(authenticationResponse, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("Credenciales invalidos", HttpStatus.UNAUTHORIZED);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



    @GetMapping("/nombre/{term}")
    public ResponseEntity<?> findByNombreAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        try {
            Optional<List<Usuarios>> result = usuarioService.findByNombreAproximateIgnoreCase(term);
            if (result.isPresent()) {
                List<UsuariosDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuariosDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        @GetMapping("/apellidos/{term}")
    public ResponseEntity<?> findByApellidosAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        try {
            Optional<List<Usuarios>> result = usuarioService.findByApellidosAproximateIgnoreCase(term);
            if (result.isPresent()) {
                List<UsuariosDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuariosDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        @GetMapping("/cedula/{term}")
    public ResponseEntity<?> findByCedulaAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        try {
            Optional<List<Usuarios>> result = usuarioService.findByCedulaAproximate(term);
            if (result.isPresent()) {
                List<UsuariosDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuariosDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        @GetMapping("/correo/{term}")
    public ResponseEntity<?> findByCorreoAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        try {
            Optional<List<Usuarios>> result = usuarioService.findByCorreoAproximate(term);
            if (result.isPresent()) {
                List<UsuariosDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuariosDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de Usuario:", response = UsuariosDTO.class, tags = "Usuarios")
    public ResponseEntity<?> create(@RequestBody Usuarios usuario) {
        try {
            Usuarios usuarioCreated = usuarioService.create(usuario);
            UsuariosDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioCreated, UsuariosDTO.class);
            return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de Usuario:", response = UsuariosDTO.class, tags = "Usuarios")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Usuarios usuarioModified) {
        try {
            Optional<Usuarios> usuarioUpdated = usuarioService.update(usuarioModified, id);
            if (usuarioUpdated.isPresent()) {
                UsuariosDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioUpdated.get(), UsuariosDTO.class);
                return new ResponseEntity<>(usuarioDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}