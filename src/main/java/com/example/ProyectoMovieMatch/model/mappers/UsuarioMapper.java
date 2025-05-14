package com.example.ProyectoMovieMatch.model.mappers;

import com.example.ProyectoMovieMatch.model.DTO.UsuarioDTO;
import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDTO toDTO(UsuarioEntity u);
    UsuarioEntity toEntity(UsuarioDTO uDTO);
}
