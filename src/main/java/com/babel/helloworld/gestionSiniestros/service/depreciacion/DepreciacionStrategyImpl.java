package com.babel.helloworld.gestionSiniestros.service.depreciacion;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepreciacionStrategyImpl implements DepreciacionStrategy {
    private final Map<String, Depreciacion> estrategiasDepreciacion;

    public DepreciacionStrategyImpl(List<Depreciacion> estrategiasDepreciacion) {
        this.estrategiasDepreciacion = estrategiasDepreciacion.stream()
                .collect(Collectors.toMap(Depreciacion::getId, estrategia -> estrategia));
    }

    public Depreciacion getDepreciacion(String id) {
        Depreciacion depreciacion = estrategiasDepreciacion.get(id);
        if (depreciacion == null) {
            return estrategiasDepreciacion.get("general");
        }else {
            return depreciacion;
        }
    }
}