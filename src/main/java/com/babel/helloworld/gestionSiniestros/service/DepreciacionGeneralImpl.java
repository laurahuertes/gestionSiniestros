package com.babel.helloworld.gestionSiniestros.service;

import com.babel.helloworld.gestionSiniestros.model.Bien;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DepreciacionGeneralImpl implements Depreciacion {
    private Double valorResidual;

    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        int tiempoAmortizacion = bien.nombre().getTiempoAmortizacion();
        double valorCompra = bien.valorCompra();
        int ayosCompraBien = bien.getAnyosAmortizados(fechaSiniestro).getYears();
        double devaluacion = (double) 1 / tiempoAmortizacion;
        double valorFinal = valorCompra;
        double valorResidual = (valorCompra * 0.15);

        for (int i = 0; i < ayosCompraBien; i++) {
            valorFinal = (valorFinal - (valorFinal * devaluacion));
            System.out.println("valorFinal: " + valorFinal);
        }

        if (valorResidual > valorFinal) {
            valorFinal = valorResidual;
        }

        return valorFinal;
    }
}
