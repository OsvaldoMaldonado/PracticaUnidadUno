package com.proyecto;

public class Usuarios {

    private String clv_usuario;
    private int id_carrera;
    private String nombre_usuario;
    private String nivel_ads;
    private String contrato;

    public String getClv_usuario() {
        return clv_usuario;
    }

    public void setClv_usuario(String clv_usuario) {
        this.clv_usuario = clv_usuario;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNivel_ads() {
        return nivel_ads;
    }

    public void setNivel_ads(String nivel_ads) {
        this.nivel_ads = nivel_ads;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
}
