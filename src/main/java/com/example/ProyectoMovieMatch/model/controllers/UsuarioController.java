package com.example.ProyectoMovieMatch.model.controllers;

import com.example.ProyectoMovieMatch.model.DTO.UsuarioDTO;
import com.example.ProyectoMovieMatch.model.entities.ContenidoEntity;
import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import com.example.ProyectoMovieMatch.model.services.UsuarioService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    // agregar todos los metodos que tengan relacion con usuario acà, no importa los cargos

    @GetMapping("/listar")
    public List<UsuarioEntity> obtenerListaUsuarios(){
        return usuarioService.findAll();
    }

    // cambiar nombre -----
    @GetMapping("/listar")
    public List<UsuarioDTO> obtenerListaDTOs(){
        return usuarioService.getAllDTO();
    }

    @PostMapping("/registrar")
    public void agregarUsuario(@RequestParam UsuarioEntity u){
        usuarioService.save(u);
    }

    @DeleteMapping("/eliminar")
    public void eliminarUsuario(@RequestParam UsuarioEntity u){
        usuarioService.deleteById(u.getId());
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerUsuario(@RequestParam long id){

        return usuarioService.getUsuarioDTO(id);
    }

    @PostMapping("/{idUsuario}/like/{idContenido}")
    public ResponseEntity<String> darLike(@PathVariable long idUsuario, @PathVariable long idContenido){
        usuarioService.darLike(idUsuario,idContenido);
        return ResponseEntity.ok("Like guardado");
    }

    @DeleteMapping("/{idUsuario}/like/{idContenido}")
    public ResponseEntity<String> quitarLike(@PathVariable long idUsuario, @PathVariable long idContenido){
        usuarioService.quitarLike(idUsuario,idContenido);
        return ResponseEntity.ok("Like eliminado");
    }


    @GetMapping("/{usuarioId}/likes")
    public ResponseEntity<Set<ContenidoEntity>> obtenerLikes(@PathVariable Long idUsuario){
        return ResponseEntity.ok(usuarioService.listarLikes(idUsuario));
    }


    // usar dto?
//    @GetMapping("/{id}")
//    public EntityModel<UsuarioDTO> obtenerUsuarioPerfil(@PathVariable Long id){
//        UsuarioDTO usuario = usuarioService.getUsuarioDTO(id);
//                //.orElseThrow(()-> new RuntimeException("error"));
//
//
//    }


}
