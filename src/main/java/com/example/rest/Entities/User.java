package com.example.rest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.text.Format;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "Empleado")
public class User {
    @Id
    private int id;
    private String nombre;
    private LocalDate fecha_nac;

    //Constructores
    public User() {
    }
    public User(int id, String nombre, LocalDate fecha_nac) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
    }

    //Getter/Setter
    public int getId() {
        return id;
    }
    public LocalDate getFecha_nac() {
        return fecha_nac;
    }
    public String getNombre() {
        return nombre;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAnno_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
