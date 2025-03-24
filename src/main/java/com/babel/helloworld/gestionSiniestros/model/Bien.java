package com.babel.helloworld.gestionSiniestros.model;

import java.time.LocalDate;
import java.time.Period;

public record Bien(TipoBien nombre, Double valorCompra, LocalDate fechaCompra) {

    public Period getAnyosAmortizados(LocalDate fechaSiniestro){
        Period periodo = Period.between(fechaCompra, fechaSiniestro);
        return periodo;
    }
}
