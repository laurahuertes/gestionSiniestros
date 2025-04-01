package com.babel.helloworld.gestionSiniestros.model.Siniestro;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Siniestro {
    private final LocalDate fechaOcurrencia;
    private final String numeroPoliza;
    private final String direccionSiniestro;
    private final String aseguradora;
    private final TipoIndemnizacion tipoIndemnizacion;
    private final List<Bien> bienesAfectados;
    private final Optional<LocalTime> horaSiniestro;
    private final Optional<String> descripcionSiniestro;

    private Siniestro(Builder builder) {
        this.fechaOcurrencia = Objects.requireNonNull(builder.fechaOcurrencia, "Fecha de ocurrencia no puede ser nula");
        this.numeroPoliza = Objects.requireNonNull(builder.numeroPoliza, "Número de póliza no puede ser nulo");
        this.direccionSiniestro = Objects.requireNonNull(builder.direccionSiniestro, "Dirección no puede ser nula");
        this.aseguradora = Objects.requireNonNull(builder.aseguradora, "Aseguradora no puede ser nula");
        this.tipoIndemnizacion = Objects.requireNonNull(builder.tipoIndemnizacion, "Tipo de indemnización no puede ser nulo");
        this.bienesAfectados = Objects.requireNonNull(builder.bienesAfectados, "Bienes afectados no puede ser nulo");
        this.horaSiniestro = Optional.ofNullable(builder.horaSiniestro);
        this.descripcionSiniestro = Optional.ofNullable(builder.descripcionSiniestro);
    }

    // Getters
    public LocalDate getFechaOcurrencia() {
        return fechaOcurrencia;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public String getDireccionSiniestro() {
        return direccionSiniestro;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public TipoIndemnizacion getTipoIndemnizacion() {
        return tipoIndemnizacion;
    }

    public List<Bien> getBienesAfectados() {
        return bienesAfectados;
    }

    public Optional<LocalTime> getHoraSiniestro() {
        return horaSiniestro;
    }

    public Optional<String> getDescripcionSiniestro() {
        return descripcionSiniestro;
    }

    public static class Builder {
        private LocalDate fechaOcurrencia;
        private String numeroPoliza;
        private String direccionSiniestro;
        private String aseguradora;
        private TipoIndemnizacion tipoIndemnizacion;
        private List<Bien> bienesAfectados;
        private LocalTime horaSiniestro;
        private String descripcionSiniestro;

        public Builder fechaOcurrencia(LocalDate fechaOcurrencia) {
            this.fechaOcurrencia = fechaOcurrencia;
            return this;
        }

        public Builder numeroPoliza(String numeroPoliza) {
            this.numeroPoliza = numeroPoliza;
            return this;
        }

        public Builder direccionSiniestro(String direccionSiniestro) {
            this.direccionSiniestro = direccionSiniestro;
            return this;
        }

        public Builder aseguradora(String aseguradora) {
            this.aseguradora = aseguradora;
            return this;
        }

        public Builder tipoIndemnizacion(TipoIndemnizacion tipoIndemnizacion) {
            this.tipoIndemnizacion = tipoIndemnizacion;
            return this;
        }

        public Builder bienesAfectados(List<Bien> bienesAfectados) {
            this.bienesAfectados = bienesAfectados;
            return this;
        }

        public Builder horaSiniestro(LocalTime horaSiniestro) {
            this.horaSiniestro = horaSiniestro;
            return this;
        }

        public Builder descripcionSiniestro(String descripcionSiniestro) {
            this.descripcionSiniestro = descripcionSiniestro;
            return this;
        }

        public Siniestro build() {
            return new Siniestro(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}