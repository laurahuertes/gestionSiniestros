package com.babel.helloworld.gestionSiniestros.service.depreciacion;

import ch.qos.logback.core.model.processor.DependencyDefinition;
import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DepreciacionService {
    private final Map<String, Depreciacion> estrategiasDepreciacion;

    public DepreciacionService() {
        this.estrategiasDepreciacion = new HashMap<>();
    }

    public void registrarEstrategia(Depreciacion estrategia) {
        estrategiasDepreciacion.put(estrategia.getId(), estrategia);
    }

    public Double calcularDepreciacion(String aseguradoraId, LocalDate fechaSiniestro, Bien bien) {
        Depreciacion depreciacion = estrategiasDepreciacion.get(aseguradoraId);
        if (depreciacion == null) {
            return estrategiasDepreciacion.get("general").CalcularPrecioBien(fechaSiniestro, bien);
        }else {
            return depreciacion.CalcularPrecioBien(fechaSiniestro, bien);
        }
    }
}