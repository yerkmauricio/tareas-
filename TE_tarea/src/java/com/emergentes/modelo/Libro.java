package com.emergentes.modelo;

public class Libro {
    
    private int id;
    private String tarea;
    private int prioridad;
    private int  completado;

    public Libro() {
        this.id = id;
        this.tarea = tarea;
        this.prioridad = prioridad;
        this.completado = completado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getCompletado() {
        return completado;
    }

    public void setCompletado(int completado) {
        this.completado = completado;
    }

    

    

}
