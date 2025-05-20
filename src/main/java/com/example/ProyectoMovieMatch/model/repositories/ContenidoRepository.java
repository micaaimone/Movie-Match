package com.example.ProyectoMovieMatch.model.repositories;

import com.example.ProyectoMovieMatch.model.entities.ContenidoEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.OfertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//esto es para sacar info de mi base de datos
public interface ContenidoRepository extends JpaRepository<ContenidoEntity, Long> {

}
