package com.zzc.misnotasapp.model;

public class Estudiante {
    private String apellido;
    private String direccion;
    private String nombre;
    private int documento;
    private int telefono;

    public Estudiante() {
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", documento=" + documento +
                ", telefono=" + telefono +
                '}';
    }
}
