package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.PeliculaEntity;
import com.example.ProyectoMovieMatch.model.entities.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
}
