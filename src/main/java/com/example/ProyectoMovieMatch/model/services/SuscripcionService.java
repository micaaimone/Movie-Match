package com.example.ProyectoMovieMatch.model.services;

import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import com.example.ProyectoMovieMatch.model.repositories.SuscripcionRepository;
import com.example.ProyectoMovieMatch.model.services.interfaz.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService implements IService<SuscripcionEntity> {
    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Override
    public List<SuscripcionEntity> findAll() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Optional<SuscripcionEntity> findById(Long id) {
        return suscripcionRepository.findById(id);
    }

    @Override
    public SuscripcionEntity save(SuscripcionEntity dato) {
        return suscripcionRepository.save(dato);
    }

    @Override
    public void delete(SuscripcionEntity dato) {
        suscripcionRepository.delete(dato);
    }



}
