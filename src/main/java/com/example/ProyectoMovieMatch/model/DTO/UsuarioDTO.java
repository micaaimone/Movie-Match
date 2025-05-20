package com.example.ProyectoMovieMatch.model.DTO;

import com.example.ProyectoMovieMatch.model.entities.ContenidoEntity;
import com.example.ProyectoMovieMatch.model.entities.CredencialEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import lombok.Data;

import java.util.Set;

@Data
public class UsuarioDTO {
    private String username;
    private String email;
    private CredencialEntity credencial;
    private SuscripcionEntity suscripcion;
    private Set<ContenidoEntity> likes;
}
