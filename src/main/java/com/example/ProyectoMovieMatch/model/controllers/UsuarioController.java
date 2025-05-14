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

    // cambiar nombre
    @GetMapping("/listar")
    public List<UsuarioDTO> obtenerListaDTOs(){
        return usuarioService.getAllDTO();
    }

    @PostMapping("/registrar")
    public void agregarUsuario(@RequestParam UsuarioEntity u){
        usuarioService.save(u);
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerUsuario(@RequestParam long id){

        return usuarioService.getUsuarioDTO(id);
    }

    // usar dto?
//    @GetMapping("/usuarios/{id}")
//    public EntityModel<UsuarioDTO> obtenerUsuarioPerfil(@PathVariable Long id){
//        UsuarioDTO usuario = usuarioService.getUsuarioDTO(id);
//                //.orElseThrow(()-> new RuntimeException("error"));
//
//
//    }


}
