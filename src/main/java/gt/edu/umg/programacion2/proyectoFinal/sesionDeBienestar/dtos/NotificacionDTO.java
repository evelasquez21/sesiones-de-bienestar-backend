/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos;

import java.time.LocalDateTime;

/**
 *
 * @author eduar
 */
public class NotificacionDTO {
    private int id;
    
    private UsuarioResumenDTO usuario;
    
    private String mensaje;
    private LocalDateTime fechaEnvio;
    
    private boolean estado;
    
    // Constructor de clase

    public NotificacionDTO() {
    }
    
    // Inicio - Sección de Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioResumenDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResumenDTO usuario) {
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
