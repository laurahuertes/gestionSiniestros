package com.babel.helloworld.gestionSiniestros.service.depreciacion.implementacion;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.Depreciacion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Qualifier("depreciacion")

public class DepreciacionGeneralImpl implements Depreciacion {
    private Double valorResidual;

    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        int tiempoAmortizacion = bien.tipoBien().getTiempoAmortizacion();
        double valorCompra = bien.valorCompra();
        int ayosCompraBien = bien.getAnyosAmortizados(fechaSiniestro).getYears();
        double devaluacion = (double) 1 / tiempoAmortizacion;
        double valorFinal = valorCompra;
        double valorResidual = (valorCompra * 0.15);
        for (int i = 0; i < ayosCompraBien; i++) {
            valorFinal = (valorFinal - (valorFinal * devaluacion));
        }
        if (valorResidual > valorFinal) {
            valorFinal = valorResidual;
        }
        return valorFinal;
    }

    @Override
    public String getId() {
        return "general";
    }
}
