package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    public List<UsuarioEntity> findByEdadGreaterThan(int edad);
    public Optional<UsuarioEntity> findByUsername(String username);
    // public UsuarioEntity findByEmail(String email);
    public UsuarioEntity modifyUsername(Long id, String username);
}
