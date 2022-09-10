package com.example.tareaandroidrestaurante;

public class Restaurante {
    private String nombre_restaurante;
    private String url_foto_restaurante;
    private float volaricion_restaurante;
    private String direccion;

    public Restaurante(String nombre_restaurante, String url_foto_restaurante, float volaricion_restaurante, String direccion) {
        this.nombre_restaurante = nombre_restaurante;
        this.url_foto_restaurante = url_foto_restaurante;
        this.volaricion_restaurante = volaricion_restaurante;
        this.direccion = direccion;
    }

    public String getNombre_restaurante() {
        return nombre_restaurante;
    }

    public void setNombre_restaurante(String nombre_restaurante) {
        this.nombre_restaurante = nombre_restaurante;
    }

    public String getUrl_foto_restaurante() {
        return url_foto_restaurante;
    }

    public void setUrl_foto_restaurante(String url_foto_restaurante) {
        this.url_foto_restaurante = url_foto_restaurante;
    }

    public float getVolaricion_restaurante() {
        return volaricion_restaurante;
    }

    public void setVolaricion_restaurante(float volaricion_restaurante) {
        this.volaricion_restaurante = volaricion_restaurante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
