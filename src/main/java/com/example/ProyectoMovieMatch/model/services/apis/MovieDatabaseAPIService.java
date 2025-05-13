package com.example.ProyectoMovieMatch.model.services.apis;

import com.example.ProyectoMovieMatch.model.entities.ContenidoEntity;
import com.example.ProyectoMovieMatch.model.repositories.ContenidoRepository;
import com.example.ProyectoMovieMatch.model.services.interfaz.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.cdimascio.dotenv.Dotenv;


import java.util.List;
import java.util.Optional;

@Service
public class MovieDatabaseAPIService implements IService<ContenidoEntity> {

    //usamos restTemplate para poder hacer peticiones a la API de pelis, es final porque solo lo quiero inicializar una vez y q no cambie
    private final RestTemplate restTemplate;
    //repo de bdd, ahi voy a guardar todas las cosas d la api, lo inyectamos por contructor y no queremos q se modifique dsps
    private final ContenidoRepository contenidoRepository;
    //url de la base de api, ahi hago las peticiones, lo dejo aca ya q lo uso varias veces, es final xq no cambia
    private final String apiUrl = "https://www.omdbapi.com/";
    //es la clave privada q me da la API para poder acceder a sus datos, se inicia una vez y no cambia
    private final String apiKey;

    public MovieDatabaseAPIService(RestTemplate restTemplate, ContenidoRepository contenidoRepository) {
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("omdbapi.key");
        if (this.apiKey == null) {
            throw new IllegalStateException("OMDBAPI_KEY no está seteada en las variables de entorno");
        }
        this.restTemplate = restTemplate;
        this.contenidoRepository = contenidoRepository;
    }




    public ContenidoEntity buscarPeliculaPorTitulo(String titulo) {
        String url = apiUrl + "?t=" + titulo + "&apikey=" + apiKey;

        return restTemplate.getForObject(url, ContenidoEntity.class);
    }

    @Override
    public List<ContenidoEntity> findAll() {
        //deberia primero cargar todo en la bdd???? me parece q no
        return contenidoRepository.findAll();
    }

    @Override
    public Optional<ContenidoEntity> findById(Long id) {
        return Optional.empty();
    }

    public Optional<ContenidoEntity> findByAPIID(String id) {
        String url = apiUrl + "=i" + id + "&apikey=" + apiKey;

        return Optional.ofNullable(restTemplate.getForObject(url, ContenidoEntity.class));
    }

    @Override
    public ContenidoEntity save(ContenidoEntity dato) {
        return contenidoRepository.save(dato);
    }

    @Override
    public void delete(ContenidoEntity dato) {
        contenidoRepository.delete(dato);
    }
}

