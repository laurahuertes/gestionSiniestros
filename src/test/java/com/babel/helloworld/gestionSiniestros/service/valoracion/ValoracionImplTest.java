package com.babel.helloworld.gestionSiniestros.service.valoracion;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import com.babel.helloworld.gestionSiniestros.model.Bien.TipoBien;
import com.babel.helloworld.gestionSiniestros.model.Siniestro.Siniestro;
import com.babel.helloworld.gestionSiniestros.model.Siniestro.TipoIndemnizacion;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.Depreciacion;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.DepreciacionStrategy;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.implementacion.DepreciacionGeneralImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValoracionImplTest {

    private ValoracionImpl valoracionImpl;
    private Siniestro siniestro;

    @Mock
    private DepreciacionStrategy depreciacionStrategyMock;

    @BeforeEach
    void setUp() {;
        Depreciacion depreciacion = new DepreciacionGeneralImpl();
        Mockito.when(depreciacionStrategyMock.getDepreciacion("")).thenReturn(depreciacion);
        List<Bien> bienesAfectados = List.of(
                new Bien("Sofá", TipoBien.MUEBLE, 1000.0, LocalDate.of(2019, 1, 1)),
                new Bien("Mesa", TipoBien.MUEBLE, 500.0, LocalDate.of(2020, 1, 1)),
                new Bien("Televisión", TipoBien.TELEVISOR, 1500.0, LocalDate.of(2021, 1, 1))
        );
        siniestro = Siniestro.builder()
                .fechaOcurrencia(LocalDate.of(2024, 4, 2))
                .numeroPoliza("POL123456")
                .direccionSiniestro("Av. Principal 123, Ciudad")
                .aseguradora("")
                .tipoIndemnizacion(TipoIndemnizacion.A_NUEVO)
                .bienesAfectados(bienesAfectados)
                .horaSiniestro(LocalTime.of(14, 30))
                .descripcionSiniestro("Incendio en el área de cocina")
                .build();

        valoracionImpl = new ValoracionImpl(depreciacionStrategyMock);
    }


    @Test
    void calcularValoracionBienesAfectados() {
            Double resultado = valoracionImpl.calcularValoracionBienesAfectados(siniestro);
            assertEquals(1500.00, resultado, 1);

    }
}