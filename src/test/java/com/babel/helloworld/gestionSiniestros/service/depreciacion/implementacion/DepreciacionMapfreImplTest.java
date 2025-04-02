package com.babel.helloworld.gestionSiniestros.service.depreciacion.implementacion;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import com.babel.helloworld.gestionSiniestros.model.Bien.TipoBien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DepreciacionMapfreImplTest {

    private DepreciacionMapfreImpl depreciacion;

    @BeforeEach
    void setUp() {
        depreciacion = new DepreciacionMapfreImpl();
    }

    @ParameterizedTest
    @CsvSource(value = {
            // Casos normales
            "ORDENADOR, 1000.0, 2020-01-01, 2021-01-01, 666.67",
            "VEHICULO, 20000.0, 2020-01-01, 2021-01-01, 18000.00",
            "TELEVISOR, 500.0, 2020-01-01, 2021-01-01, 400.00",

            // Casos de valores extremos y límites
            "ORDENADOR, 1000.0, 2022-01-01, 2022-01-01, 1000.00",
            "ORDENADOR, 1000.0, 2000-01-01, 2023-01-01, 170.00",
            "VEHICULO, 20000.0, 2000-01-01, 2023-01-01, 3400.00",

            // Casos con valores decimal extremos
            "ORDENADOR, 999.99, 2020-01-01, 2021-01-01, 666.66",
            "MUEBLE, 1234.56, 2020-01-01, 2021-01-01, 1058.19"
    })
    void calcularPrecioBien_ValoresLimiteYNormales(String nombre, double valorCompra, String fechaCompraStr,
                                                   String fechaSiniestroStr, double expected) {
        LocalDate fechaCompra = LocalDate.parse(fechaCompraStr);
        LocalDate fechaSiniestro = LocalDate.parse(fechaSiniestroStr);

        Bien bien = new Bien(nombre, TipoBien.valueOf(nombre), valorCompra, fechaCompra);
        Double result = depreciacion.CalcularPrecioBien(fechaSiniestro, bien);

        assertEquals(expected, result, 0.01, "El valor calculado no coincide con el esperado");
    }

    @Test
    void getId() {
        assertEquals("mapfre", depreciacion.getId());
    }
}