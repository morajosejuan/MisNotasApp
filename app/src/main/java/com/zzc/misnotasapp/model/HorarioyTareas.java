package com.zzc.misnotasapp.model;

import java.util.Date;

public class HorarioyTareas {
    private Date dia;
    private String tarea;


    public HorarioyTareas() {

    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    @Override
    public String toString() {
        return "HorarioyTareas{" +
                "dia=" + dia +
                ", tarea='" + tarea + '\'' +
                '}';
    }
}
