package com.example.ProyectoMovieMatch.model.services;

import com.example.ProyectoMovieMatch.model.entities.suscripcion.PagoEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import com.example.ProyectoMovieMatch.model.repositories.PagoRepository;
import com.example.ProyectoMovieMatch.model.services.interfaz.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService implements IService <PagoEntity>{
    @Autowired
    private PagoRepository pagoRepository;


    @Override
    public List<PagoEntity> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<PagoEntity> findById(Long id) {
        return pagoRepository.findById(id);
    }

    @Override
    public PagoEntity save(PagoEntity dato) {
        return pagoRepository.save(dato);
    }

    @Override
    public void delete(PagoEntity dato) {
        pagoRepository.delete(dato);
    }
}
