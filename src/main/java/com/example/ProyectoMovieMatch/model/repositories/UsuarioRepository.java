package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
