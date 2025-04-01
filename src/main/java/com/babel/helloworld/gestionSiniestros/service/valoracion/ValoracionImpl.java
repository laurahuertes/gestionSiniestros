package com.babel.helloworld.gestionSiniestros.service.valoracion;

import com.babel.helloworld.gestionSiniestros.model.Siniestro.Siniestro;
import org.springframework.stereotype.Component;

@Component
public class ValoracionImpl implements Valoracion{



    @Override
    public Double calcularValoracionBienesAfectados(Siniestro siniestro) {

        return 0.0;
    }
}
