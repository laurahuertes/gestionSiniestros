package com.babel.helloworld.gestionSiniestros.service;

import com.babel.helloworld.gestionSiniestros.model.Bien;

import java.time.LocalDate;

public class DepreciacionAllianzImpl implements Depreciacion{
    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        Double valoracion = bien.valorCompra();
        for(int anyo = 0; anyo<=bien.nombre().getTiempoAmortizacion(); anyo++){

        }
        return valoracion + valoracion*0.05;
    }
}
