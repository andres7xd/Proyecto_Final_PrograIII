/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites_aeropuerto.dto.Usuarios_AreasDTO;

/**
 *
 * @author Luis
 */
public interface IUsuarios_AreasService {
    
    public Optional<List<Usuarios_AreasDTO>> findAll();
    
    public Optional<Usuarios_AreasDTO> findById(Long id);
     
    public Usuarios_AreasDTO create(Usuarios_AreasDTO usuarios_AreasDTO);

    public Optional<Usuarios_AreasDTO> update(Usuarios_AreasDTO usuarios_AreasDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
    
}
