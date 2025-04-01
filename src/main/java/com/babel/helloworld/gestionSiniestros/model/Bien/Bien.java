package com.babel.helloworld.gestionSiniestros.model.Bien;

import java.time.LocalDate;
import java.time.Period;


public record Bien(String nombre, TipoBien tipoBien, Double valorCompra, LocalDate fechaCompra) {

    public Period getAnyosAmortizados(LocalDate fechaSiniestro) {
        Period periodo = Period.between(fechaCompra, fechaSiniestro);
        return periodo;
    }
}
