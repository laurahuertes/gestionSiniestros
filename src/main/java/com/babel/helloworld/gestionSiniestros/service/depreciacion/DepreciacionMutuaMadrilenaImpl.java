package com.babel.helloworld.gestionSiniestros.service.depreciacion;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
@Qualifier("depreciacion")

public class DepreciacionMutuaMadrilenaImpl implements Depreciacion {

    private Double residualValue = 0.1;

    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        double valoracion = bien.valorCompra();
        double valoracionResidual = bien.valorCompra() * residualValue;
        double deprecacion = (double) 1 / (bien.tipoBien().getTiempoAmortizacion() * 2 * 365);
        System.out.println("deprecacion:" + deprecacion);

        int diasAmortizados = calcularDias(bien.getAnyosAmortizados(fechaSiniestro));

        for (int dia = 0; dia < diasAmortizados; dia++) {
            valoracion -= valoracion * deprecacion;
            System.out.println("valoracion:" + valoracion);
        }
        return Math.max(valoracion, valoracionResidual);
    }

    private int calcularDias(Period period) {
        int diasAmortizacion = period.getYears() * 365 + period.getMonths() * 30 + period.getDays();
        return diasAmortizacion;
    }

    @Override
    public String getId() {
        return "mutuaMadrilena";
    }
}
