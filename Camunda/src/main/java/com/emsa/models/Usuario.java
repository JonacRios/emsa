package com.emsa.models;

import java.io.Serial;
import java.io.Serializable;

public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String nombre;
    private String contacto;
    private String direccion;
    private String barrio;
    private String estrato;
    private String tipoServicio;

    public Usuario(String id, String tipoServicio, String estrato, String barrio, String direccion, String contacto, String nombre) {
        this.id = id;
        this.tipoServicio = tipoServicio;
        this.estrato = estrato;
        this.barrio = barrio;
        this.direccion = direccion;
        this.contacto = contacto;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contacto=" + contacto +
                ", direccion='" + direccion + '\'' +
                ", barrio='" + barrio + '\'' +
                ", estrato=" + estrato +
                ", tipoServicio='" + tipoServicio + '\'' +
                '}';
    }
}
