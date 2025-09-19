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
public class RegistroAuditoria {
    private int id;
    private Empleado empleado;
    private LocalDateTime fechaHora;
    private String accion;
    private String detalles;
    
    // Constructor de clase
    public RegistroAuditoria(int id, Empleado empleado, LocalDateTime fechaHora, String accion, String detalles) {
        this.id = id;
        this.empleado = empleado;
        this.fechaHora = fechaHora;
        this.accion = accion;
        this.detalles = detalles;
    }
    
    // Inicio - Sección de Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
}
