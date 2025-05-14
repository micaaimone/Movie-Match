package com.example.ProyectoMovieMatch.model.controllers;

import com.example.ProyectoMovieMatch.model.DTO.UsuarioDTO;
import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import com.example.ProyectoMovieMatch.model.services.UsuarioService;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    // manejar excepciones y usar dtos

    @GetMapping("/listar")
    public List<UsuarioEntity> obtenerListaUsuarios(){
        return usuarioService.findAll();
    }

    @PostMapping("/registrar")
    public void agregarUsuario(@RequestParam UsuarioEntity u){
        usuarioService.save(u);
    }

    @GetMapping("/{id}")
    public Optional<UsuarioEntity> obtenerUsuario(@RequestParam long id){
        return usuarioService.findById(id);
    }

    // usar dto?
    @GetMapping("/usuarios/{id}")
    public EntityModel<UsuarioEntity> obtenerUsuarioPerfil(@PathVariable Long id){
        UsuarioEntity usuario = usuarioService.findById(id)
                .orElseThrow(()-> new RuntimeException("error"));


    }


}
