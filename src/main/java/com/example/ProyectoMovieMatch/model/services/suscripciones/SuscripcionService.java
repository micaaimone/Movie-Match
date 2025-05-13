package com.example.ProyectoMovieMatch.model.services.suscripciones;

import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.PlanSuscripcionEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.TipoSuscripcion;
import com.example.ProyectoMovieMatch.model.repositories.PlanRepository;
import com.example.ProyectoMovieMatch.model.repositories.SuscripcionRepository;
import com.example.ProyectoMovieMatch.model.services.apis.MercadoPagoService;
import com.example.ProyectoMovieMatch.model.services.interfaz.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService implements IService<SuscripcionEntity> {
    @Autowired
    private SuscripcionRepository suscripcionRepository;
    @Autowired
    private MercadoPagoService mercadoPagoService;
    @Autowired
    private PlanRepository planRepository;
    //@Autowired
    //private UsuarioRepository usuarioRepository;

    @Override
    public List<SuscripcionEntity> findAll() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Optional<SuscripcionEntity> findById(Long id) {
        return suscripcionRepository.findById(id);
    }
/*
    @Override
    public String save(Long id_usuario, TipoSuscripcion dato) {
        UsuarioEntity usuario = usuarioRepository.findById(id_usuario);
        //buscamos el plan
        PlanSuscripcionEntity plan = planRepository.findByTipo(dato)
                .orElseThrow(()-> new RuntimeException("no se enocntro el plan"));

        //creamos la sub
        SuscripcionEntity suscripcion = new SuscripcionEntity();
        //todaia no esta activada hasta que se concrete el pago
        suscripcion.setEstado(false);
        suscripcion.setMonto(plan.getPrecio());
        suscripcion.setPlan(plan);
        //suscripcion.setUsuario(usuario);
        suscripcion.setFecha_inicio(LocalDate.now());
        suscripcion.setFecha_fin(calcularFechaFin(dato));

        //creamos el pago
        suscripcionRepository.save(suscripcion);


        return mercadoPagoService.crearPreferenciaDePrueba(dato.name(), suscripcion.getMonto());
    }*/

    private LocalDate calcularFechaFin(TipoSuscripcion tipo) {
        return tipo == TipoSuscripcion.MENSUAL
                ? LocalDate.now().plusMonths(1)
                : LocalDate.now().plusYears(1);
    }

    @Override
    public void delete(SuscripcionEntity dato) {
        suscripcionRepository.delete(dato);
    }

    //verifica si la fecha de hoy es menor que la de vencimiento
    public boolean vencio(SuscripcionEntity suscripcion){
        LocalDate hoy = LocalDate.now();
        return hoy.isAfter(suscripcion.getFecha_fin());
    }

    //utiliza la verificacion y si caduco cambia el estado
    public void verificarVencimiento(Long id){
        SuscripcionEntity sub = suscripcionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("no existe la suscripcion"));

        if(vencio(sub)){
            System.out.println("⛔ La suscripción ya venció.");
            sub.setEstado(false);
            suscripcionRepository.save(sub);
        }else{
            System.out.println("✅ La suscripción aún está activa.");
        }
    }

    //listar activos
    public List<SuscripcionEntity> findActivos(){
        return suscripcionRepository.findActivos();
    }
}
