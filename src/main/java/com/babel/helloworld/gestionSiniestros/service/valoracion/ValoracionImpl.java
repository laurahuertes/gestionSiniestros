package com.babel.helloworld.gestionSiniestros.service.valoracion;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import com.babel.helloworld.gestionSiniestros.model.Siniestro.Siniestro;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.Depreciacion;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.DepreciacionStrategy;
import org.springframework.stereotype.Component;

@Component
public class ValoracionImpl implements Valoracion{

    private DepreciacionStrategy depreciacionStrategy;

    public ValoracionImpl(DepreciacionStrategy depreciacionStrategy) {
        this.depreciacionStrategy = depreciacionStrategy;
    }

    @Override
    public Double calcularValoracionBienesAfectados(Siniestro siniestro) {
        Depreciacion depreciacion = depreciacionStrategy.getDepreciacion(siniestro.getAseguradora());
        Double res = 0.0;
        for (Bien bien: siniestro.getBienesAfectados()) {
            res += depreciacion.CalcularPrecioBien(siniestro.getFechaOcurrencia(), bien);
        }
        return res;
    }

}
