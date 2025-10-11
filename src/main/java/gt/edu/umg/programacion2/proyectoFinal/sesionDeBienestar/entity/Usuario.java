/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 *
 * @author eduar
 */

@Entity
public class Usuario extends Persona{
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "contrasena")
    private String contrasena;
    
    private boolean cuentaBloqueada = false;
    private int intentosFallidos = 0;
    private LocalDateTime tiempoDeDesbloqueo;
    
    // Constructor de clase
    public Usuario() {
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

    public boolean isCuentaBloqueada() {
        return cuentaBloqueada;
    }

    public void setCuentaBloqueada(boolean cuentaBloqueada) {
        this.cuentaBloqueada = cuentaBloqueada;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public LocalDateTime getTiempoDeDesbloqueo() {
        return tiempoDeDesbloqueo;
    }

    public void setTiempoDeDesbloqueo(LocalDateTime tiempoDeDesbloqueo) {
        this.tiempoDeDesbloqueo = tiempoDeDesbloqueo;
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
        return getCorreo() != null && getCorreo().equals(usuario.getCorreo());
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), correo);
    }
    
    // Final Métodos equals y hashcode
}
