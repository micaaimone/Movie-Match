package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.ContenidoEntity;
import com.example.ProyectoMovieMatch.model.entities.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {
}
