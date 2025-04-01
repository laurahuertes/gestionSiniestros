package com.babel.helloworld.gestionSiniestros.service.depreciacion;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;

import java.time.LocalDate;

public interface Depreciacion {
    Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien);
    String getId();
}
