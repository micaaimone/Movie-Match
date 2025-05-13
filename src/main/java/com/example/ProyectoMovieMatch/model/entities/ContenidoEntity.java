package com.example.ProyectoMovieMatch.model.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "contenidos")
public class ContenidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contenido;

    @JsonProperty("Title")
    private String titulo;

    @JsonProperty("Year")
    private String anio;

    @JsonProperty("Rated")
    private String clasificacion;

    @JsonProperty("Released")
    private String lanzamiento;

    @JsonProperty("Runtime")
    private String duracion;

    @JsonProperty("Genre")
    private String genero;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Writer")
    private String guionista;

    @JsonProperty("Actors")
    private String actores;

    @JsonProperty("Plot")
    private String sinopsis;

    @JsonProperty("Language")
    private String idioma;

    @JsonProperty("Country")
    private String pais;

    @JsonProperty("Awards")
    private String premios;

    @JsonProperty("Poster")
    private String poster;

    @OneToMany(mappedBy = "contenido", cascade = CascadeType.ALL)
    @JsonProperty("Ratings")
    private List<RatingEntity> ratings;

    @JsonProperty("Metascore")
    private String metascore;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("imdbVotes")
    private String imdbVotos;

    @JsonProperty("imdbID")
    private String imdbId;

    @JsonProperty("Type")
    private String tipo;

    @JsonProperty("DVD")
    private String dvd;

    @JsonProperty("BoxOffice")
    private String recaudacion;

    @JsonProperty("Production")
    private String productora;

    @JsonProperty("Website")
    private String sitioWeb;

    @JsonProperty("Response")
    private String respuesta;

}
