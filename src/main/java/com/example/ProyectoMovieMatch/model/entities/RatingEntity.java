package com.example.ProyectoMovieMatch.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ratings")
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rating;

    @ManyToOne
    @JoinColumn(name = "id_contenido")
    private ContenidoEntity contenido;

    @JsonProperty("Source")
    private String fuente;

    @JsonProperty("Value")
    private String valor;
}
