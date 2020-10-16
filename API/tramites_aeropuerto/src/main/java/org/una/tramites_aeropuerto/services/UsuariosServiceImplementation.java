/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.una.tramites_aeropuerto.dto.UsuariosDTO;

import org.una.tramites_aeropuerto.entities.Usuarios;
import org.una.tramites_aeropuerto.jwt.JwtProvider;
import org.una.tramites_aeropuerto.repositories.IUsuariosRepository;
import org.una.tramites_aeropuerto.utils.Convertir;
import org.una.tramites_aeropuerto.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class UsuariosServiceImplementation implements IUsuariosService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IUsuariosRepository usuariosRepository;

    @Override
    public Optional<List<UsuariosDTO>> findAll() {
        return (Optional<List<UsuariosDTO>>) Convertir.findList(Optional.ofNullable(usuariosRepository.findAll()), UsuariosDTO.class);
    }

    @Override
    public Optional<UsuariosDTO> findById(Long id) {
        return (Optional<UsuariosDTO>) Convertir.oneToDto(usuariosRepository.findById(id), UsuariosDTO.class);
    }

    @Override
    public Optional<List<UsuariosDTO>> findByCedulaAproximate(String cedula) {
        return (Optional<List<UsuariosDTO>>) Convertir.findList(Optional.ofNullable(usuariosRepository.findByCedulaContaining(cedula)), UsuariosDTO.class);
    }

    @Override
    public Optional<List<UsuariosDTO>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto) {
        return (Optional<List<UsuariosDTO>>) Convertir.findList(Optional.ofNullable(usuariosRepository.findByNombreCompletoContainingIgnoreCase(nombreCompleto)), UsuariosDTO.class);
    }

    @Override
    @Transactional
    public UsuariosDTO create(UsuariosDTO usuariosDTO) {
        encriptarContrasena(usuariosDTO);
        Usuarios usuarios = MapperUtils.EntityFromDto(usuariosDTO, Usuarios.class);
        usuarios = usuariosRepository.save(usuarios);
        return MapperUtils.DtoFromEntity(usuarios, UsuariosDTO.class);
    }

    @Override
    @Transactional
    public Optional<UsuariosDTO> update(UsuariosDTO usuariosDTO, Long id) {
        if (usuariosRepository.findById(id).isPresent()) {
            Usuarios usuarios = MapperUtils.EntityFromDto(usuariosDTO, Usuarios.class);
            usuarios = usuariosRepository.save(usuarios);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(usuarios, UsuariosDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        usuariosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        usuariosRepository.deleteAll();
    }

    @Override
    public Optional<List<UsuariosDTO>> findByRolesId(Long id) {
        return (Optional<List<UsuariosDTO>>) Convertir.findList(Optional.ofNullable(usuariosRepository.findByRolesId(id)), UsuariosDTO.class);
    }

    @Override

    public Optional<UsuariosDTO> findByCedula(String cedula) {
        return (Optional<UsuariosDTO>) Convertir.oneToDto(Optional.ofNullable(usuariosRepository.findByCedula(cedula)), UsuariosDTO.class);
    }

    @Override
    public Optional<List<UsuariosDTO>> findByCorreoAproximate(String correo) {
        return (Optional<List<UsuariosDTO>>) Convertir.findList(Optional.ofNullable(usuariosRepository.findByCorreoContaining(correo)), UsuariosDTO.class);
    }

    @Override
    public Optional<List<UsuariosDTO>> findByEmpleadoId(Long id) {
        return (Optional<List<UsuariosDTO>>) Convertir.findList(Optional.ofNullable(usuariosRepository.findByEmpleadoId(id)), UsuariosDTO.class);
    }

    private void encriptarContrasena(UsuariosDTO usuariosDTO) {
        String password = usuariosDTO.getContrasenaEncriptada();
        if (!password.isBlank()) {
            usuariosDTO.setContrasenaEncriptada(bCryptPasswordEncoder.encode(password));
        }
    }

}
