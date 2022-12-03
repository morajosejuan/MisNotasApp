package com.zzc.misnotasapp.model;

public class NotasyCurso {
    private int creditos;
    private String materia;
    private float nota;
    private float promedio;

    public NotasyCurso() {
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "NotasyCurso{" +
                "creditos=" + creditos +
                ", materia='" + materia + '\'' +
                ", nota=" + nota +
                ", promedio=" + promedio +
                '}';
    }
}
