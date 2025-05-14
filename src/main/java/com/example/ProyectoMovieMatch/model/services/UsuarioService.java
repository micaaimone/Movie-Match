package com.example.ProyectoMovieMatch.model.services;

import com.example.ProyectoMovieMatch.model.DTO.UsuarioDTO;
import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import com.example.ProyectoMovieMatch.model.mappers.UsuarioMapper;
import com.example.ProyectoMovieMatch.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private UsuarioMapper usuarioMapper;

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

    public List<UsuarioEntity> usuariosMayores(int edad){
        return usuarioRepository.findByEdadGreaterThan(edad);
    }

    public UsuarioDTO getUsuarioDTO(Long id){
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).orElseThrow();
        return usuarioMapper.toDTO(usuarioEntity);
    }

    public List<UsuarioDTO> getAllDTO(){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
