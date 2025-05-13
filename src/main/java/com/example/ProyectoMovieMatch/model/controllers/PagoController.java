package com.example.ProyectoMovieMatch.model.controllers;

import com.example.ProyectoMovieMatch.model.services.apis.MercadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pago")
public class PagoController {


    @Autowired
    private MercadoPagoService mp;

    @GetMapping("/crear")
    public ResponseEntity<String> crearPago() {
        String linkPago = mp.crearPreferenciaDePrueba();
        if (linkPago != null) {
            return ResponseEntity.ok(linkPago);
        } else {
            return ResponseEntity.status(500).body("Error al generar la preferencia");
        }
    }

    @GetMapping("/success")
    public String pagoExitoso() {
        return "¡Pago exitoso!";
    }

    @GetMapping("/failure")
    public String pagoFallido() {
        return "El pago fue rechazado";
    }

    @GetMapping("/pending")
    public String pagoPendiente() {
        return "El pago está pendiente de aprobación";
    }
}
