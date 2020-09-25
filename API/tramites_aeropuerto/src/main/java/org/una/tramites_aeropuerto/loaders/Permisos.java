/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.loaders;

/**
 *
 * @author rache
 */
public enum Permisos {
    USUARIOS_CREAR("USU1"),
    USUARIOS_MODIFICAR("USU2"),
    USUARIOS_INACTIVAR("USU3"),
    USUARIOS_CONSULTAR("USU4"),
    USUARIOS_CONSULTAR_TODO("USU5"),
    USUARIOS_VERIFICAR("USU6"),
    USUARIOS_AUTORIZAR("USU7"),
    USUARIOS_EMITIR("USU8"),
    NOTIFICACIONES_CREAR("NOT1"),
    NOTIFICACIONES_INACTIVAR("NOT2"),
    NOTIFICACIONES_CONSULTAR("NOT3"),
    NOTIFICACIONES_CONSULTAR_TODO("NOT4"),
    HORARIOS_CREAR("HOR1"),
    HORARIOS_MODIFICAR("HOR2"),
    HORARIOS_MODIFICAR_CONSULTAR("HOR3"),
    HORARIOS_MODIFICAR_CONSULTAR_TODO("HOR4"),
    AREAS_TRABAJO_CREAR("ATRA1"),
    AREAS_TRABAJO_CONSULTAR("ATRA2"),
    AREAS_TRABAJO_CONSULTAR_TODO("ATRA3"),
    MARCAS_HORARIO_CREAR("MHO1"),
    MARCAS_HORARIO_CONSULTAR("MHO2"),
    MARCAS_HORARIO_CONSULTAR_TODO("MHO3");
    
    private final String rol;

    Permisos(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}
