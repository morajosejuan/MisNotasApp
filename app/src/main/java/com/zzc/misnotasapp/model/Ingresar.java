package com.zzc.misnotasapp.model;

public class Ingresar {
    private String usuario;
    private String aadmin;

    public Ingresar() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAadmin() {
        return aadmin;
    }

    public void setAadmin(String aadmin) {
        this.aadmin = aadmin;
    }

    @Override
    public String toString() {
        return "Ingresar{" +
                "usuario='" + usuario + '\'' +
                ", aadmin='" + aadmin + '\'' +
                '}';
    }
}
