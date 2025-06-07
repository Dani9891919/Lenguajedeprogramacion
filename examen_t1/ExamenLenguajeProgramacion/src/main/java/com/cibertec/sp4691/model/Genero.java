package com.cibertec.sp4691.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "genero")
public class Genero implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgenero")
    private int idgenero;

    @Column(name = "nombre", length = 45)
    private String nombre;

    public Genero() {
    }

    // Getters y Setters
    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Genero [idgenero=" + idgenero + ", nombre=" + nombre + "]";
    }
}