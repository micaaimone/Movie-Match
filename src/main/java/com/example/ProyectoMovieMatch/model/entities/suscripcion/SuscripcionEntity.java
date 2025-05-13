package com.example.ProyectoMovieMatch.model.entities.suscripcion;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "suscripciones")
public class SuscripcionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSuscripcion;

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private boolean estado;

    //pongo manytoOne porque por ej la sub de un año puede tener descuento pero la mensual no
    @ManyToOne
    @JoinColumn(name = "id_oferta", nullable = true)
    private OfertaEntity oferta;  // Puede ser null si no hay oferta


}

