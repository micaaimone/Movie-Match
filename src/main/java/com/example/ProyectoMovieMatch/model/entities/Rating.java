package com.example.ProyectoMovieMatch.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Rating {

    @JsonProperty("Source")
    private String fuente;

    @JsonProperty("Value")
    private String valor;
}
