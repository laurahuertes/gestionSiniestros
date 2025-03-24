package com.babel.helloworld.gestionSiniestros.service;

import com.babel.helloworld.gestionSiniestros.model.Bien;

import java.time.LocalDate;

public class DepreciacionGeneralImpl implements Depreciacion {
    private Double valorResidual;

    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        int tiempoAmortizacion = bien.nombre().getTiempoAmortizacion();
        double valorCompra = bien.valorCompra();

        return 0.0;
    }
}
