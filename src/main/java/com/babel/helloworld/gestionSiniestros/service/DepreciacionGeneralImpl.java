package com.babel.helloworld.gestionSiniestros.service;

import com.babel.helloworld.gestionSiniestros.model.Bien;

import java.time.LocalDate;

public class DepreciacionGeneralImpl implements Depreciacion {
    private Double valorResidual;

    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        int tiempoAmortizacion = bien.nombre().getTiempoAmortizacion();
        double valorCompra = bien.valorCompra();
        int ayosCompraBien = bien.getAnyosAmortizados(fechaSiniestro).getYears();
        int devaluacion = tiempoAmortizacion / 100;
        double valorFinal = valorCompra;
        double valorResidual = valorCompra * 0.15;

        for (int i = 0; i < ayosCompraBien; i++) {
            valorFinal = valorFinal - (valorFinal * devaluacion);
        }

        if (valorResidual > valorFinal) {
            valorFinal = valorResidual;
        }

        return valorFinal;
    }
}
