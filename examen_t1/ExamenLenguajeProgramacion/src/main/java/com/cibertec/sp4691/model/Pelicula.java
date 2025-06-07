package com.cibertec.sp4691.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date; // Usaremos java.util.Date para fechaEstreno

@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpelicula")
    private int idpelicula;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "director", length = 45)
    private String director;

    @Temporal(TemporalType.DATE) // Para mapear a tipo DATE en MySQL
    @Column(name = "fechaEstreno")
    private Date fechaEstreno;

    @ManyToOne
    @JoinColumn(name = "idgenero") // Columna de la clave foránea
    private Genero genero; // Objeto Genero que representa la relación

    public Pelicula() {
    }

    // Getters y Setters
    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula [idpelicula=" + idpelicula + ", nombre=" + nombre + ", director=" + director
                + ", fechaEstreno=" + fechaEstreno + ", genero=" + (genero != null ? genero.getNombre() : "null") + "]";
    }
}