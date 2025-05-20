package com.example.ProyectoMovieMatch.model.entities;

import com.example.ProyectoMovieMatch.model.enums.E_Rango;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class CredencialEntity {
    @Id
    private long id;

    @Column(name = "rango", nullable = false)
    private E_Rango rango;
}
