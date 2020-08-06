package com.guayaba.ejemploviewmodel.dto;

public class Version {
    private int id;
    private String nombre;
    private double version;
    private int api;

    public Version(int id, String nombre, double version, int api) {
        this.id = id;
        this.nombre = nombre;
        this.version = version;
        this.api = api;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVersion() {
        return version;
    }

    public int getApi() {
        return api;
    }
}
