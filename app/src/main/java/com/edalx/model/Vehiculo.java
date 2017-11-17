package com.edalx.model;

import java.util.Date;

/**
 * Created by edd_a on 12/11/2017.
 */

public class Vehiculo {
    private String placa;
    private String marca;
    private String fecFab;
    private Double costo;
    private Boolean matriculado;
    private String color;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String fecFab, Double costo, Boolean matriculado, String color) {
        this.placa = placa;
        this.marca = marca;
        this.fecFab = fecFab;
        this.costo = costo;
        this.matriculado = matriculado;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFecFab() {
        return fecFab;
    }

    public void setFecFab(String fecFab) {
        this.fecFab = fecFab;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Boolean getMatriculado() {
        return matriculado;
    }

    public void setMatriculado(Boolean matriculado) {
        this.matriculado = matriculado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", fecFab='" + fecFab + '\'' +
                ", costo=" + costo +
                ", matriculado=" + matriculado +
                ", color='" + color + '\'' +
                '}';
    }
}
