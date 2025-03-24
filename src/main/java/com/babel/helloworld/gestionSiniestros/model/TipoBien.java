package com.babel.helloworld.gestionSiniestros.model;

public enum TipoBien {

    ORDENADOR(3),
    VEHICULO(10),
    TELEVISOR(5),
    MUEBLE(7),
    NEVERA(8);

    private int tiempoAmortizacion;

    TipoBien(int tiempoAmortizacion) {
        this.tiempoAmortizacion = tiempoAmortizacion;
    }

    public int getTiempoAmortizacion() {
        return tiempoAmortizacion;
    }


}
