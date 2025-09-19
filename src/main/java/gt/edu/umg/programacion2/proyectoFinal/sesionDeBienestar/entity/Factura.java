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
public class Factura {
    private int id;
    private LocalDateTime fechaEmision;
    private double total;
    private boolean estado;

    // Constructor de clase
    public Factura(int id, LocalDateTime fechaEmision, double total, boolean estado) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.estado = estado;
    }
    
    // Inicio - Sección de Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    // Fin - Sección de Getters y Setters
    
}
