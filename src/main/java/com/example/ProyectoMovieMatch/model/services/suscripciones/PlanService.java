package com.example.ProyectoMovieMatch.model.services.suscripciones;

import com.example.ProyectoMovieMatch.model.entities.suscripcion.PlanSuscripcionEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.TipoSuscripcion;
import com.example.ProyectoMovieMatch.model.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.ProyectoMovieMatch.model.entities.suscripcion.TipoSuscripcion.*;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    public List<PlanSuscripcionEntity> verTodos(){
        return planRepository.findAll();
    }

    public void crearPlan(float precio, TipoSuscripcion tipo){
        PlanSuscripcionEntity plan = new PlanSuscripcionEntity();
        plan.setTipo(tipo);
        plan.setPrecio(precio);

        planRepository.save(plan);
    }

    public void cambiarMontoPlan(float montoNuevo, Long id){
        planRepository.actualizarPrecio(id, montoNuevo);
    }

    public float precioFinal (float monto, float desc){
        if(desc != 0){
            float extra=(monto * desc)/100;
            monto-=extra;
        }
        return monto;
    }
}
