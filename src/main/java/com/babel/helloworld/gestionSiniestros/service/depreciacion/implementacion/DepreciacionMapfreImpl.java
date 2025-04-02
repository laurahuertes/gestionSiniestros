package com.babel.helloworld.gestionSiniestros.service.depreciacion.implementacion;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.Depreciacion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Qualifier("depreciacion")

public class DepreciacionMapfreImpl implements Depreciacion {
    private final double VALOR_RESIDUAL = 0.17;

    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {
        /*
        -La depreciación no es acumulada.
        Por tanto, en el ejemplo anterior el cálculo sería: 1500 - (1500*0.2) = 1200 € -> Valor real
        -Aplica un 17% de valor residual
         */

        int anyosCompra = bien.getAnyosAmortizados(fechaSiniestro).getYears();

        int tiempoAmortizacion = bien.tipoBien().getTiempoAmortizacion();

        double porcentajeDepreciacion = (double) 1 / tiempoAmortizacion;

        double valor = bien.valorCompra() - (bien.valorCompra() * (porcentajeDepreciacion * anyosCompra));


        double valorMinimo = bien.valorCompra() * VALOR_RESIDUAL;
        if (valor < valorMinimo) {
            valor = valorMinimo;
        }

        return valor;
    }

    @Override
    public String getId() {
        return "mapfre";
    }
}
