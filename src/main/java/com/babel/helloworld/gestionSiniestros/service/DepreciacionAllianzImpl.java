package com.babel.helloworld.gestionSiniestros.service;

import com.babel.helloworld.gestionSiniestros.model.Bien;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DepreciacionAllianzImpl implements Depreciacion {
    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        double valoracion = bien.valorCompra();
        int tiempoAmortizacion = bien.nombre().getTiempoAmortizacion();
        double deprecacion = (double) 1 / tiempoAmortizacion;
        int anyosAmortizados = bien.getAnyosAmortizados(fechaSiniestro).getYears();

        for (int anyo = 0; anyo <= anyosAmortizados; anyo++) {
            valoracion -= valoracion * deprecacion;

        }
        return valoracion + valoracion * 0.05;
    }
}
