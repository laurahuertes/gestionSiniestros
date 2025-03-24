package com.babel.helloworld.gestionSiniestros.service;

import com.babel.helloworld.gestionSiniestros.model.Bien;

import java.time.LocalDate;

public class DepreciacionGeneralImpl implements Depreciacion {
    @Override
    public Double CalcularPrecioBien(LocalDate fechaSiniestro, Bien bien) {


        return 0.0;
    }
}
