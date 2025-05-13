package com.example.ProyectoMovieMatch.model.services.interfaz;

import com.example.ProyectoMovieMatch.model.entities.ContenidoEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;

import java.util.List;
import java.util.Optional;

public interface IService <T>{

    public List<T> findAll();

    public Optional<T> findById(Long id);


    public void delete(T dato);
}
