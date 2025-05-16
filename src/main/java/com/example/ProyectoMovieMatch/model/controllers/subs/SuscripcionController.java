package com.example.ProyectoMovieMatch.model.controllers.subs;

import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.TipoSuscripcion;
import com.example.ProyectoMovieMatch.model.services.suscripciones.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionService suscripcionService;

    //funciones de admin

    //listar todos
    @GetMapping("/listar")
    public List<SuscripcionEntity> listar(){
        return suscripcionService.findAll();
    }

    //buscar por id
    @GetMapping("/{id}")
    public Optional<SuscripcionEntity> buscarID(Long id){
        return suscripcionService.findById(id);
    }

    // listar subs activas
    @GetMapping("/activas")
    public List<SuscripcionEntity> listarActivas(){
        return suscripcionService.findActivos();
    }

    //metods de usuario
    @PostMapping("/crear")
    public void crear(UsuarioEntity usuario, TipoSuscripcion tipo){
        suscripcionService.save(usuario.getId(), tipo);
    }


}
