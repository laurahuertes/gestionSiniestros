package com.babel.helloworld.gestionSiniestros.service;

import com.babel.helloworld.gestionSiniestros.model.Bien;

import java.time.LocalDate;

public interface Depreciacion {
    Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien);
}
