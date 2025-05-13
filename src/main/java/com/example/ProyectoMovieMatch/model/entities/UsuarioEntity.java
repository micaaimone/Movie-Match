package com.example.ProyectoMovieMatch.model.entities;

import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column(name = "email", unique = true)
    private String email;

    @Column
    private int edad;

    @Column
    private long telefono;

    @Size(min = 6, max = 30)
    @Column(name = "contrasenia", nullable = false, length = 30)
    private String contrasenia;

    @Size(min = 4)
    @Column(name = "username", unique = true)
    private String username;

    @OneToOne
    @JoinColumn(name = "id_credencial")
    private CredencialEntity credencial;

    @OneToOne
    @JoinColumn(name = "id_suscripcion")
    private SuscripcionEntity suscripcion;


}
