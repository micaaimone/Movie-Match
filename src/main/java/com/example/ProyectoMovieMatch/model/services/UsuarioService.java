package com.example.ProyectoMovieMatch.model.services;

import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import com.example.ProyectoMovieMatch.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> findAll(){
        return usuarioRepository.findAll();
    }

    public void save(UsuarioEntity u){
        usuarioRepository.save(u);
    }

    public Optional<UsuarioEntity> findById(long id){
        return usuarioRepository.findById(id);
    }

    public void deleteById(long id){
        usuarioRepository.deleteById(id);
    }

    // preguntar si era asi
//    public List<UsuarioEntity> usuariosMayores(int edad){
//        return usuarioRepository.findByEdadGreaterThan(edad);
//    }
}
