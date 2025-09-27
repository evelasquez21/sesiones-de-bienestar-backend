/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author eduar
 */

@Entity
public class RegistroAuditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "empleado_codigo")
    private Empleado empleado;
    
    @Column(name = "fechaHora")
    private LocalDateTime fechaHora;
    
    @Column(name = "accion")
    private String accion;
    
    @Column(name = "detalles")
    private String detalles;
    
    // Constructor de clase
    public RegistroAuditoria(){
        
    }
    
    public RegistroAuditoria(Long id, Empleado empleado, LocalDateTime fechaHora, String accion, String detalles) {
        this.id = id;
        this.empleado = empleado;
        this.fechaHora = fechaHora;
        this.accion = accion;
        this.detalles = detalles;
    }
    
    // Inicio - Sección de Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    // Fin - Sección de Getters y Setters
    
    // Inicio Métodos equals y hashcode
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return  false;
        RegistroAuditoria regAuditoria = (RegistroAuditoria) o;
        return getId() != 0 && getId().equals(regAuditoria.getId());
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(empleado, fechaHora);
    }
    
    // Final Métodos equals y hashcode
}
