package com.example.rest.Entities;

public class User {
    private int id, anno_nac;
    private String nombre;

    //Constructores
    public User() {
    }
    public User(int id, String nombre, int anno_nac) {
        this.id = id;
        this.nombre = nombre;
        this.anno_nac = anno_nac;
    }

    //Getter/Setter
    public int getId() {
        return id;
    }
    public int getAnno_nac() {
        return anno_nac;
    }
    public String getNombre() {
        return nombre;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAnno_nac(int anno_nac) {
        this.anno_nac = anno_nac;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
