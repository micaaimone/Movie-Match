package com.example.ProyectoMovieMatch.model.services;

import com.example.ProyectoMovieMatch.model.entities.suscripcion.OfertaEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import com.example.ProyectoMovieMatch.model.repositories.OfertaRepository;
import com.example.ProyectoMovieMatch.model.services.interfaz.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfertaService implements IService<OfertaEntity> {
    @Autowired
    private OfertaRepository ofertaRepository;


    @Override
    public List<OfertaEntity> findAll() {
        return ofertaRepository.findAll();
    }

    @Override
    public Optional<OfertaEntity> findById(Long id) {
        return ofertaRepository.findById(id);
    }

    @Override
    public OfertaEntity save(OfertaEntity dato) {
        return ofertaRepository.save(dato);
    }

    @Override
    public void delete(OfertaEntity dato) {
        ofertaRepository.delete(dato);
    }



}
