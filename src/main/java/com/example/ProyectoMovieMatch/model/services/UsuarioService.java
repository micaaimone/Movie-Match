package com.example.ProyectoMovieMatch.model.services;

import com.example.ProyectoMovieMatch.model.DTO.UsuarioDTO;
import com.example.ProyectoMovieMatch.model.entities.ContenidoEntity;
import com.example.ProyectoMovieMatch.model.entities.PeliculaEntity;
import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import com.example.ProyectoMovieMatch.model.exceptions.ListaVaciaException;
import com.example.ProyectoMovieMatch.model.exceptions.UsuarioNoEncontradoException;
import com.example.ProyectoMovieMatch.model.mappers.UsuarioMapper;
import com.example.ProyectoMovieMatch.model.repositories.PeliculaRepository;
import com.example.ProyectoMovieMatch.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private UsuarioMapper usuarioMapper;

    // hacer validaciones y exceptions acà, meter el codigo pesado

    @Autowired
    private UsuarioRepository usuarioRepository;
    private ContenidoService contenidoService;

    public List<UsuarioEntity> findAll() throws ListaVaciaException {
        if(usuarioRepository.findAll().isEmpty()){
            throw new ListaVaciaException("No hay usuarios");
        }
        return usuarioRepository.findAll();
    }

    public void save(UsuarioEntity u){
        usuarioRepository.save(u);
    }

    public Optional<UsuarioEntity> findById(Long id) throws UsuarioNoEncontradoException {
        if(usuarioRepository.findById(id).isEmpty()){
            throw new UsuarioNoEncontradoException("El usuario no existe");
        }
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioEntity> findByUsername(String username){return usuarioRepository.findByUsername(username);}

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

    // modificar usuario
//    public UsuarioDTO modifyUsername(Long id, String username){
//        return getUsuarioDTO(id).setUsername(username);
//
//    }

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


    public void darLike(Long idUsuario, Long idContenido){
        UsuarioEntity usuarioEntity = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        ContenidoEntity contenidoEntity = contenidoService.findById(idContenido)
                .orElseThrow(()->new RuntimeException("Contenido no encontrado"));

        usuarioEntity.getLikes().add(contenidoEntity);
        usuarioRepository.save(usuarioEntity);
    }

    public void quitarLike(Long idUsuario, Long idContenido){
        UsuarioEntity usuarioEntity = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        // agregar find by id
        ContenidoEntity contenidoEntity = contenidoService.findById(idContenido)
                .orElseThrow(()->new RuntimeException("Contenido no encontrado"));

        usuarioEntity.getLikes().remove(contenidoEntity);
        usuarioRepository.save(usuarioEntity);
    }

    public Set<ContenidoEntity> listarLikes(Long id){
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuarioEntity.getLikes();
    }

}
