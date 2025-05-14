package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.ContenidoEntity;
import com.example.ProyectoMovieMatch.model.entities.SerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<SerieEntity, Long> {
}
