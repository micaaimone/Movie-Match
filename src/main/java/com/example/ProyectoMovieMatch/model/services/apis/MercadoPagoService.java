package com.example.ProyectoMovieMatch.model.services.apis;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.*;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoService {

    @Value("${MERCADOPAGO_ACCESS_TOKEN}")
    private String accessToken;

    @PostConstruct
    public void init() throws MPConfException {

        MercadoPago.SDK.setAccessToken(accessToken);

        System.out.println("✅ Token de Mercado Pago configurado correctamente");
    }

    public String crearPreferenciaDePrueba(String titulo, float monto) {
        try {
            //cada url nueva q genero de ngrok  
            //acordar tambein actualizar en links de mp
            String urlNgrok="https://afb8-2803-9800-9995-6e65-2de5-a20c-d524-b8ca.ngrok-free.app";
            Preference preference = new Preference();

            Item item = new Item();
            item.setTitle(titulo)
                    .setQuantity(1)
                    .setUnitPrice(monto);

            preference.appendItem(item);

            // URLs de redirección
            BackUrls backUrls = new BackUrls();
            backUrls.setSuccess(urlNgrok+"/api/pago/success")
                    .setFailure(urlNgrok+"/api/pago/failure")
                    .setPending(urlNgrok+"/api/pago/pending");
            preference.setBackUrls(backUrls);
            preference.setAutoReturn(Preference.AutoReturn.approved);

            preference.save();
            if (preference.getId() == null || preference.getInitPoint() == null) {
                System.out.println("❌ Error: la preferencia no se generó correctamente.");
                System.out.println("Respuesta completa: " + preference.getLastApiResponse());
            }

            System.out.println("Link de pago generado: " + preference.getInitPoint());
            return preference.getInitPoint(); // Devuelve el link para pagar
        } catch (Exception e) {

            System.out.println("Error al crear preferencia: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

