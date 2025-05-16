package com.example.ProyectoMovieMatch.model.entities.suscripcion;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "plan_suscripcion")
public class PlanSuscripcionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoSuscripcion tipo;

    private float precio;

    @OneToOne
    @JoinColumn(name = "id_oferta", nullable = true)
    private OfertaEntity oferta;
}
