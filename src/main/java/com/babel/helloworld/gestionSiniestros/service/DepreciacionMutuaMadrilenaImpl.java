package com.babel.helloworld.gestionSiniestros.service;

import com.babel.helloworld.gestionSiniestros.model.Bien;

import java.time.LocalDate;

public class DepreciacionMutuaMadrilenaImpl implements Depreciacion{

    private Double residualValue = 0.1;

    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        Double valoracion = bien.valorCompra();
        Double valoracionResidual = bien.valorCompra()*residualValue;
        Double deprecacion = (double) (1 / (bien.nombre().getTiempoAmortizacion() * 2 * 365));
        int diasAmortizados = bien.getAnyosAmortizados(fechaSiniestro).getDays();
        for (int dia = 0; dia < diasAmortizados; dia++) {
                valoracion -= valoracion * deprecacion;
        }
        return Math.max(valoracion, valoracionResidual);
    }
}
