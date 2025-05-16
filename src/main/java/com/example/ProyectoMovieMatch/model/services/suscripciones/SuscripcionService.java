package com.example.ProyectoMovieMatch.model.services.suscripciones;

import com.example.ProyectoMovieMatch.model.entities.UsuarioEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.OfertaEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.PlanSuscripcionEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.SuscripcionEntity;
import com.example.ProyectoMovieMatch.model.entities.suscripcion.TipoSuscripcion;
import com.example.ProyectoMovieMatch.model.repositories.OfertaRepository;
import com.example.ProyectoMovieMatch.model.repositories.PlanRepository;
import com.example.ProyectoMovieMatch.model.repositories.SuscripcionRepository;
import com.example.ProyectoMovieMatch.model.repositories.UsuarioRepository;
import com.example.ProyectoMovieMatch.model.services.apis.MercadoPagoService;
import com.example.ProyectoMovieMatch.model.services.interfaz.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService implements IService<SuscripcionEntity> {
    private final SuscripcionRepository suscripcionRepository;
    private final MercadoPagoService mercadoPagoService;
    private final PlanRepository planRepository;
    private final OfertaRepository ofertaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PlanService planService;

    public SuscripcionService(SuscripcionRepository suscripcionRepository, MercadoPagoService mercadoPagoService, PlanRepository planRepository, OfertaRepository ofertaRepository, UsuarioRepository usuarioRepository, PlanService planService) {
        this.suscripcionRepository = suscripcionRepository;
        this.mercadoPagoService = mercadoPagoService;
        this.planRepository = planRepository;
        this.ofertaRepository = ofertaRepository;
        this.usuarioRepository = usuarioRepository;
        this.planService = planService;
    }


    @Override
    public List<SuscripcionEntity> findAll() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Optional<SuscripcionEntity> findById(Long id) {
        return suscripcionRepository.findById(id);
    }

    @Override
    public void delete(SuscripcionEntity dato) {
        suscripcionRepository.delete(dato);
    }

    //
    public String save(Long id_usuario, TipoSuscripcion dato) {

        UsuarioEntity usuario = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario"));

        //buscamos el plan
        PlanSuscripcionEntity plan = planRepository.findByTipo(dato)
                .orElseThrow(() -> new RuntimeException("no se enocntro el plan"));

        //buscamos oferta activa
        OfertaEntity oferta = ofertaRepository.buscarOferta(plan.getId(), LocalDate.now());


        //creamos la sub
        SuscripcionEntity suscripcion = new SuscripcionEntity();
        //todaia no esta activada hasta que se concrete el pago
        suscripcion.setEstado(false);

        if(oferta != null){
            suscripcion.setMonto(planService.precioFinal(plan.getPrecio(), oferta.getDescuento()));
        }else{
            suscripcion.setMonto(plan.getPrecio());
        }

        suscripcion.setPlan(plan);
        suscripcion.setUsuario(usuario);
        suscripcion.setFecha_inicio(LocalDate.now());
        suscripcion.setFecha_fin(calcularFechaFin(dato));

        //creamos el pago
        suscripcionRepository.save(suscripcion);


        return mercadoPagoService.crearPreferenciaDePrueba(dato.name(), suscripcion.getMonto());
    }

    //indica cuando se terminara la sub segun el tipo
    private LocalDate calcularFechaFin(TipoSuscripcion tipo) {
        return switch (tipo) {
            case MENSUAL -> LocalDate.now().plusMonths(1);
            case SEMESTRAl -> LocalDate.now().plusMonths(6);
            case ANUAL -> LocalDate.now().plusYears(1);
        };
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

    //activar la sub cuando se concrete el pago
    public void activarSuscripion(Long id){
        suscripcionRepository.activatSub(id);
    }
}
