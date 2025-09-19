/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import jakarta.persistence.Entity;
import java.util.Objects;


/**
 *
 * @author eduar
 */

@Entity
public class Usuario extends Persona{
    private String correo;
    private String contrasena;
    
    // Constructor de clase
    public Usuario() {
    }
    
    public Usuario(String correo, String contrasena) {
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
    
    // Inicio Métodos equals y hashcode
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return  false;
        Usuario usuario = (Usuario) o;
        return getDpi() != null && getDpi().equals(usuario.getDpi());
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), correo);
    }
    
    // Final Métodos equals y hashcode
}
