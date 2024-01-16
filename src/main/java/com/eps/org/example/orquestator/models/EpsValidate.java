package com.eps.org.example.orquestator.models;

public class EpsValidate {
    private long idEps;
    private String nombreEps;
    private double porcentaje;
    private double comisionSobreRA;
    private double primaSeguro;

    public EpsValidate() {
    }

    public EpsValidate(long idEps, String nombreEps, double porcentaje, double comisionSobreRA, double primaSeguro) {
        this.idEps = idEps;
        this.nombreEps = nombreEps;
        this.porcentaje = porcentaje;
        this.comisionSobreRA = comisionSobreRA;
        this.primaSeguro = primaSeguro;
    }

    public long getIdEps() {
        return this.idEps;
    }

    public void setIdEps(long idEps) {
        this.idEps = idEps;
    }

    public String getNombreEps() {
        return this.nombreEps;
    }

    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }

    public double getPorcentaje() {
        return this.porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getComisionSobreRA() {
        return this.comisionSobreRA;
    }

    public void setComisionSobreRA(double comisionSobreRA) {
        this.comisionSobreRA = comisionSobreRA;
    }

    public double getPrimaSeguro() {
        return this.primaSeguro;
    }

    public void setPrimaSeguro(double primaSeguro) {
        this.primaSeguro = primaSeguro;
    }
}
