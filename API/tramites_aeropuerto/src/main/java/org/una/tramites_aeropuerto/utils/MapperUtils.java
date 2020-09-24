/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto.utils;

/**
 *
 * @author rache
 */
import org.modelmapper.convention.MatchingStrategies;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;


/**
 *
 *@author rache
 */
public class MapperUtils {

    private static ModelMapper modelMapper = new ModelMapper() {};

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private MapperUtils() {
    }

    public static <D, E> D DtoFromEntity(final E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public static <D, E> List<D> DtoListFromEntityList(final Collection<E> entityList, Class<D> dtoClass) {
        return entityList.stream()
                .map(entity -> DtoFromEntity(entity, dtoClass))
                .collect(Collectors.toList());
    }

}