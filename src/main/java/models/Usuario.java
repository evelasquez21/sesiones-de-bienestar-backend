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
public class Usuario extends Persona{
    private String correo;
    private String contrasena;
    
    // Constructor de clase
    public Usuario(String correo, String contrasena, BigInteger dpi, String nombreCompleto, String direccion, LocalDate fechaNacimiento, int telefono) {
        super(dpi, nombreCompleto, direccion, fechaNacimiento, telefono);
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Inicio - Sección de Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    // Fin - Sección de Getters y Setters
    
    @Override
    public String toString(){
        return 
            super.toString() +
            "\nCorreo: " + this.correo;
    }
}
