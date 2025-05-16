package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.suscripcion.OfertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface OfertaRepository extends JpaRepository <OfertaEntity, Long> {

    @Query("SELECT o FROM ofertas o WHERE o.id_plan = :id AND :fecha BETWEEN o.fecha_inicio AND o.fecha_fin")
    OfertaEntity buscarOferta(@Param("id") long id, @Param("fecha")LocalDate fecha);
}
