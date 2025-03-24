package com.babel.helloworld.gestionSiniestros.model;

import java.time.LocalDate;

public record Bien(TipoBien nombre, Double valorCompra, LocalDate fechaCompra) {
}
