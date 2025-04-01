package com.babel.helloworld.gestionSiniestros.service.valoracion;

import com.babel.helloworld.gestionSiniestros.model.Siniestro.Siniestro;

public interface Valoracion {

    Double calcularValoracionBienesAfectados(Siniestro siniestro);
}
