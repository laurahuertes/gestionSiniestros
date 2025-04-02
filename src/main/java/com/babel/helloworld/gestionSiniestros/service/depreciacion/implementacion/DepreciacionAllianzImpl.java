package com.babel.helloworld.gestionSiniestros.service.depreciacion.implementacion;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.Depreciacion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Qualifier("depreciacion")
public class DepreciacionAllianzImpl implements Depreciacion {
    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        double valoracion = bien.valorCompra();
        int tiempoAmortizacion = bien.tipoBien().getTiempoAmortizacion();
        double deprecacion = (double) 1 / tiempoAmortizacion;
        int anyosAmortizados = bien.getAnyosAmortizados(fechaSiniestro).getYears();

        for (int anyo = 0; anyo <= anyosAmortizados; anyo++) {
            valoracion -= valoracion * deprecacion;

        }
        return valoracion + valoracion * 0.05;
    }

    @Override
    public String getId() {
        return "allianz";
    }
}
