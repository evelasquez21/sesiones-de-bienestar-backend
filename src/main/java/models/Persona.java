/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 *
 * @author eduar
 */
public abstract class Persona {
    private BigInteger dpi;
    private String nombreCompleto;
    private String direccion;
    private LocalDate fechaNacimiento;
    private int telefono;
    
    // Constructor de clase
    public Persona(BigInteger dpi, String nombreCompleto, String direccion, LocalDate fechaNacimiento, int telefono){
        this.dpi = dpi;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    // Inicio - Sección de Getters y Setters
    public BigInteger getDpi() {
        return dpi;
    }

    public void setDpi(BigInteger dpi) {
        this.dpi = dpi;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    // Fin - Sección de Getters y Setters
    
    @Override
    public String toString(){
        return 
                "DPI: " + this.dpi +
                "\nNombre completo: " + this.nombreCompleto +
                "\nDireccion: " + this.direccion;
    }
    
    
}
