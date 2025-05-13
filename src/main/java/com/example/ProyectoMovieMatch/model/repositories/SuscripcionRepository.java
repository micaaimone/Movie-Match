package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.suscripcion.OfertaEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuscripcionRepository extends JpaRepository<SuscripcionEntity, Long> {

    @Query(value = "SELECT * FROM suscripciones WHERE estado = 1", nativeQuery = true)
    List<SuscripcionEntity> findActivos();
}
