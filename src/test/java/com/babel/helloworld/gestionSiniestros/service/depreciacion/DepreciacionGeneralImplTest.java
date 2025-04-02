package com.babel.helloworld.gestionSiniestros.service.depreciacion;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import com.babel.helloworld.gestionSiniestros.model.Bien.TipoBien;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.implementaciones.DepreciacionGeneralImpl;
import org.junit.jupiter.api.BeforeEach;
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
            "ORDENADOR, 1000.0, 2020-01-01, 2021-01-01, 666.67",
            "VEHICULO, 20000.0, 2020-01-01, 2021-01-01, 18000.00",
            "TELEVISOR, 500.0, 2020-01-01, 2021-01-01, 400.00",
            "MUEBLE, 1000.0, 2020-01-01, 2021-01-01, 857.14",
            "NEVERA, 800.0, 2020-01-01, 2021-01-01, 700.00",

            "ORDENADOR, 1000.0, 2018-01-01, 2021-01-01, 296.30",
            "VEHICULO, 20000.0, 2015-01-01, 2020-01-01, 8609.34",
            "TELEVISOR, 500.0, 2018-01-01, 2023-01-01, 163.84",
            "MUEBLE, 1000.0, 2015-01-01, 2022-01-01, 320.00",
            "NEVERA, 800.0, 2019-01-01, 2023-01-01, 327.68",

            "ORDENADOR, 1000.0, 2022-01-01, 2022-06-01, 1000.00",
            "VEHICULO, 20000.0, 2022-01-01, 2022-12-31, 20000.00",

            "ORDENADOR, 1000.0, 2010-01-01, 2023-01-01, 150.00",
            "VEHICULO, 20000.0, 2000-01-01, 2023-01-01, 3000.00",
            "TELEVISOR, 500.0, 2010-01-01, 2023-01-01, 75.00",

            "ORDENADOR, 999.99, 2020-01-01, 2021-01-01, 666.66",
            "MUEBLE, 1234.56, 2020-01-01, 2021-01-01, 1058.19"
    })
    void calcularPrecioBien_CasosGenerales(TipoBien tipoBien, Double valorCompra, LocalDate fechaCompra,
                                           LocalDate fechaSiniestro, Double expected) {
        Bien bien = new Bien(tipoBien, valorCompra, fechaCompra);
        Double result = depreciacion.CalcularPrecioBien(fechaSiniestro, bien);
        assertEquals(expected, result, 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "ORDENADOR, 1000.0, 2020-01-01, 2020-01-01, 1000.00",
            "VEHICULO, 20000.0, 2020-01-01, 2020-01-01, 20000.00",

            "ORDENADOR, 1000.0, 2021-01-01, 2020-01-01, 1000.00",
            "TELEVISOR, 500.0, 2022-01-01, 2021-12-31, 500.00"
    })
    void calcularPrecioBien_FechasEspeciales(TipoBien tipoBien, Double valorCompra, LocalDate fechaCompra,
                                             LocalDate fechaSiniestro, Double expected) {
        Bien bien = new Bien(tipoBien, valorCompra, fechaCompra);
        Double result = depreciacion.CalcularPrecioBien(fechaSiniestro, bien);
        assertEquals(expected, result, 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "ORDENADOR, 1000.0, 2010-01-01, 2023-01-01, 150.00",
            "VEHICULO, 20000.0, 2000-01-01, 2023-01-01, 3000.00",
            "TELEVISOR, 500.0, 2015-01-01, 2025-01-01, 75.00",
            "MUEBLE, 1000.0, 2010-01-01, 2023-01-01, 150.00"
    })
    void calcularPrecioBien_ValorResidual(TipoBien tipoBien, Double valorCompra, LocalDate fechaCompra,
                                          LocalDate fechaSiniestro, Double expected) {
        Bien bien = new Bien(tipoBien, valorCompra, fechaCompra);
        Double result = depreciacion.CalcularPrecioBien(fechaSiniestro, bien);
        assertEquals(expected, result, 0.01);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.01, 1.0, 100.0, 1000000.0})
    void calcularPrecioBien_ValoresExtremos(Double valorCompra) {
        TipoBien tipo = TipoBien.ORDENADOR;
        LocalDate fechaCompra = LocalDate.of(2020, 1, 1);
        LocalDate fechaSiniestro = LocalDate.of(2021, 1, 1);

        Bien bien = new Bien(tipo, valorCompra, fechaCompra);
        Double result = depreciacion.CalcularPrecioBien(fechaSiniestro, bien);

        Double expected = valorCompra * 2.0 / 3.0;
        assertEquals(expected, result, 0.01);
    }
}