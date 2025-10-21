/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.AuditListener;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author eduar
 */

@Entity
@EntityListeners(AuditListener.class)
public class Usuario extends Persona{
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "contrasena")
    private String contrasena;
    
    private boolean cuentaBloqueada = false;
    private int intentosFallidos = 0;
    private LocalDateTime tiempoDeDesbloqueo;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Notificacion> notificaciones = new ArrayList<>();
    
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
    
    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
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
