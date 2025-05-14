package com.example.ProyectoMovieMatch.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "series")
public class SerieEntity extends ContenidoEntity{

    @JsonProperty("totalSeasons")
    private String totalSeasons;
}
