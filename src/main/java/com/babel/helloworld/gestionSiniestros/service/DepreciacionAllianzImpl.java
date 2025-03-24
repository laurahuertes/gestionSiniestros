package com.babel.helloworld.gestionSiniestros.service;

import com.babel.helloworld.gestionSiniestros.model.Bien;

import java.time.LocalDate;

public class DepreciacionAllianzImpl implements Depreciacion{
    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        Double valoracion = bien.valorCompra();
        Double deprecacion = (double) (1 / bien.nombre().getTiempoAmortizacion());
        int anyosAmortizados = bien.getAnyosAmortizados(fechaSiniestro).getYears();
        for(int anyo = 0; anyo<=anyosAmortizados; anyo++){
            valoracion -= valoracion*deprecacion;
        }
        return valoracion + valoracion*0.05;
    }
}
