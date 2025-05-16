package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.suscripcion.OfertaEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuscripcionRepository extends JpaRepository<SuscripcionEntity, Long> {

    @Query(value = "SELECT * FROM suscripciones WHERE estado = 1", nativeQuery = true)
    List<SuscripcionEntity> findActivos();

    @Modifying
    @Query("UPDATE suscripciones s SET s.estado = 1 WHERE idSuscripcion = :id")
    void activatSub(@Param("id") Long id);
}
