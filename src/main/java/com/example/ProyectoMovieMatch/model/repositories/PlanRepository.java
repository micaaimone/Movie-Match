package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.suscripcion.PlanSuscripcionEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.TipoSuscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlanRepository extends JpaRepository<PlanSuscripcionEntity, Long> {

    @Modifying
    @Query("UPDATE plan_suscripcion p SET p.precio = :precio WHERE p.id = :id")
    void actualizarPrecio(@Param("id") Long id ,@Param("precio") float precio);

    @Query("select * from plan_suscripcion where tipo = :tipo")
    Optional<PlanSuscripcionEntity> findByTipo(@Param("tipo") TipoSuscripcion tipo);
}
