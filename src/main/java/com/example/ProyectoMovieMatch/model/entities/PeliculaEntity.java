package com.example.ProyectoMovieMatch.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "peliculas")
public class PeliculaEntity extends ContenidoEntity{

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Metascore")
    private String metascore;

    @JsonProperty("DVD")
    private String dvd;

    @JsonProperty("BoxOffice")
    private String recaudacion;

    @JsonProperty("Production")
    private String productora;

    @JsonProperty("Website")
    private String sitioWeb;


}
