/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.AuditListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Objects;

/**
 *
 * @author eduar
 */

@Entity
@EntityListeners(AuditListener.class)
public class Empleado {
    @Id
    private Long codigo;
    
    private String rol;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_dpi")
    private Usuario usuario;
    
    // Constructor de clase
    public Empleado(){
        
    }

    
    // Inicio - Sección de Getters y Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long carnet) {
        this.codigo = carnet;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    // Fin - Sección de Getters y Setters

    
}
