package com.babel.helloworld.gestionSiniestros.service.depreciacion.implementacion;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import com.babel.helloworld.gestionSiniestros.model.Bien.TipoBien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepreciacionGeneralImplTest {

    private DepreciacionGeneralImpl depreciacion;

    @BeforeEach
    void setUp() {
        depreciacion = new DepreciacionGeneralImpl();
    }

    @ParameterizedTest
    @CsvSource({
            // Casos normales
            "ORDENADOR, 1000.0, 2020-01-01, 2021-01-01, 666.67",
            "VEHICULO, 20000.0, 2020-01-01, 2021-01-01, 18000.00",
            "TELEVISOR, 500.0, 2020-01-01, 2021-01-01, 400.00",

            // Casos de valores extremos y límites
            "ORDENADOR, 1000.0, 2022-01-01, 2022-01-01, 1000.00",  // Mismo día de compra
            "ORDENADOR, 1000.0, 2000-01-01, 2023-01-01, 150.00",   // Mucho tiempo de uso
            "VEHICULO, 20000.0, 2000-01-01, 2023-01-01, 3000.00",  // Valor residual mayor que el calculado

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
        assertEquals("general", depreciacion.getId());
    }


}