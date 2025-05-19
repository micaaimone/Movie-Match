package com.example.ProyectoMovieMatch.model.controllers;

import com.example.ProyectoMovieMatch.model.entities.ContenidoEntity;
import com.example.ProyectoMovieMatch.model.entities.PeliculaEntity;
import com.example.ProyectoMovieMatch.model.entities.SerieEntity;
import com.example.ProyectoMovieMatch.model.repositories.ContenidoRepository;
import com.example.ProyectoMovieMatch.model.services.ContenidoService;
import com.example.ProyectoMovieMatch.model.services.apis.APIMovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MoviesDatabaseControllers {

    private final APIMovieService movieServices;
    private final ContenidoService contenidoService;

    public MoviesDatabaseControllers(APIMovieService omdbService, ContenidoRepository contenidoRepository, ContenidoService contenidoService) {
        this.movieServices = omdbService;
        this.contenidoService = contenidoService;
    }

//    @GetMapping("/findByTitle/{titulo}")
//    public ContenidoEntity obtenerPelicula(@PathVariable String titulo) {
//        return movieServices.findByTitle(titulo);
//    }

    @GetMapping("/findByImdbId/{imdbId}")
    public Optional<ContenidoEntity> obtenerPeliculaPorId(@PathVariable String imdbId) {
        return movieServices.findByAPIID(imdbId);
    }


    @GetMapping("/verSeries")
    public List<SerieEntity> serieRepo()
    {
        return contenidoService.datosSerieBDD();
    }

    @GetMapping("/verPeliculas")
    public List<PeliculaEntity> peliculaRepo()
    {
        return contenidoService.datosPeliculaBDD();
    }

    @GetMapping("/verSeriesYPeliculas")
    public List<ContenidoEntity> todo()
    {
        return contenidoService.datosBDD();
    }

}
