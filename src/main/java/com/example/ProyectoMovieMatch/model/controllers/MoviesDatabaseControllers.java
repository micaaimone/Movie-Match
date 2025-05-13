package com.example.ProyectoMovieMatch.model.controllers;

import com.example.ProyectoMovieMatch.model.entities.ContenidoEntity;
import com.example.ProyectoMovieMatch.model.services.apis.MovieDatabaseAPIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
public class MoviesDatabaseControllers {

    private final MovieDatabaseAPIService movieServices;

    public MoviesDatabaseControllers(MovieDatabaseAPIService omdbService) {
        this.movieServices = omdbService;
    }

    @GetMapping("/buscarPorTitulo/{titulo}")
    public ContenidoEntity obtenerPelicula(@PathVariable String titulo) {
        return movieServices.buscarPeliculaPorTitulo(titulo);
    }

    //no arroja nada
    @GetMapping("/listadoPeliculas")
    public List<ContenidoEntity> listadoPeliculas(){
        return movieServices.findAll();
    }

    //no entiendo como buscarlo, el id segun el json es tt1517268 ?
    @GetMapping("/buscarPorId/{id}")
    public Optional<ContenidoEntity> obtenerPelicula(@PathVariable Long id) {
        return movieServices.findById(id);
    }

    @GetMapping("/buscarPorIdAPI/{imdbId}")
    public Optional<ContenidoEntity> obtenerPeliculaPorId(@PathVariable String imdbId) {
        return movieServices.findByAPIID(imdbId);
    }


}
