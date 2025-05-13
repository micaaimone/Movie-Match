package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.suscripcion.OfertaEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends JpaRepository<SuscripcionEntity, Long> {

}
