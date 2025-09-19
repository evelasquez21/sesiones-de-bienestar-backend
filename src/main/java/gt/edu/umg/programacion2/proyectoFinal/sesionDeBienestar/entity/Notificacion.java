/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import java.time.LocalDateTime;

/**
 *
 * @author eduar
 */
public class Notificacion {
    private int id;
    private Usuario usuario;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private boolean estado;

    // Constructor de clase
    public Notificacion(int id, Usuario usuario, String mensaje, LocalDateTime fechaEnvio, boolean estado) {
        this.id = id;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
    }

    // Inicio - Sección de Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    // Fin - Sección de Getters y Setters
    
}
