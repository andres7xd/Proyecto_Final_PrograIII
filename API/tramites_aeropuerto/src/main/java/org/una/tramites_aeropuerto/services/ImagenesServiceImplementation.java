///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.una.tramites_aeropuerto.services;
//
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.una.tramites_aeropuerto.entities.Imagenes;
//import org.una.tramites_aeropuerto.repositories.ImagenesRepository;
//
//
///**
// *
// * @author andre
// */
//@Service
//public class ImagenesServiceImplementation implements IImagenesService {
//    
//    
//    @Autowired
//    private ImagenesRepository imagenesRepository;
//    
//     @Override
//    @Transactional
//    public Imagenes create(Imagenes imagenes) {
//        return imagenesRepository.save(imagenes);
//    }
//
//    
//     @Override
//    @Transactional(readOnly = true)
//    public Optional<Imagenes> findById(Long id) {
//        return imagenesRepository.findById(id);
//      
//    }
//
//   
//
//    @Override
//    @Transactional
//    public Optional<Imagenes> update(Imagenes imagenes, Long id) {
//        if (imagenesRepository.findById(id).isPresent()) {
//            return Optional.ofNullable(imagenesRepository.save(imagenes));
//        } else {
//            return null;
//        }
//
//    }
//
//    @Override
//    @Transactional
//    public void delete(Long id) {
//
//        imagenesRepository.deleteById(id);
//    }
//
//    @Override
//    @Transactional
//    public void deleteAll() {
//        imagenesRepository.deleteAll();
//    }
//
////    @Override
////    public Optional<List<Imagenes>> findAll() {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
//
//    @Override
//    public Optional<Imagenes> findByImagen_Adjunta(String Imagen_Adjunta){
//        return Optional.ofNullable(imagenesRepository.findByImagen_Adjunta(Imagen_Adjunta));
//    }
//}