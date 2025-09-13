/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author eduar
 */
public class Servicio {
    private String codigo;
    private String nombre;
    private double precio;
    private int duracion;
    private int maxConcurrentes;
    private boolean estado;

    // Constructor de clase
    public Servicio(String codigo, String nombre, double precio, int duracion, int maxConcurrentes, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;
        this.maxConcurrentes = maxConcurrentes;
        this.estado = estado;
    }
    
    // Inicio - Sección de Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getMaxConcurrentes() {
        return maxConcurrentes;
    }

    public void setMaxConcurrentes(int maxConcurrentes) {
        this.maxConcurrentes = maxConcurrentes;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    // Fin - Sección de Getters y Setters
    
}
