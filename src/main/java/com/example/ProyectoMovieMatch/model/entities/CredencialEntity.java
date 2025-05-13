package com.example.ProyectoMovieMatch.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CredencialEntity {
    @Id
    private long id;

    @Column(name = "rango", nullable = false)
    private E_Rango rango;
}
