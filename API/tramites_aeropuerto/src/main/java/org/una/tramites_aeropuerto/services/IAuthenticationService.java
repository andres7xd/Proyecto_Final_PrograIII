/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import org.una.tramites_aeropuerto.dto.AuthenticationRequest;
import org.una.tramites_aeropuerto.dto.AuthenticationResponse;

/**
 *
 * @author andre
 */
public interface IAuthenticationService {
     public AuthenticationResponse  login(AuthenticationRequest authenticationRequest);
}
