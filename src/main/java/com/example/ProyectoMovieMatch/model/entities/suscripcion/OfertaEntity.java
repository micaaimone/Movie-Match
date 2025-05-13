package com.example.ProyectoMovieMatch.model.entities.suscripcion;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "ofertas")
public class OfertaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_oferta;

    private String descripcion;
    private float descuento;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
}
