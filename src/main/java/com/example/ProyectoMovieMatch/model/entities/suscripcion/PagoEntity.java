package com.example.ProyectoMovieMatch.model.entities.suscripcion;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pagos")
public class PagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medio_pago;
    private LocalDateTime fecha_pago;

    @ManyToOne
    @JoinColumn(name = "id_suscripcion", nullable = false)
    private SuscripcionEntity suscripcion;

}
