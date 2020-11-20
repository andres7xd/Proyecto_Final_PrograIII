/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites_aeropuerto.reports.ConeccionReporte;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/reportes")

public class ConeccionReporteController {

    @Autowired
    private ConeccionReporte coneccionReporte;

    @GetMapping("/{nombreReporte}")
    @ResponseBody

    ResponseEntity<?> findReporte(@PathVariable(value = "nombreReporte") String nombre) {
        try {
            return new ResponseEntity<>(coneccionReporte.Connecion(nombre), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
