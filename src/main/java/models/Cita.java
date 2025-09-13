/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;

/**
 *
 * @author eduar
 */
public class Cita {
    private int id;
    private LocalDateTime fechaHora;
    private int estado;
    private Servicio servicio;
    private Factura factura;
    
    // Constructor de clase
    public Cita(int id, LocalDateTime fechaHora, int estado, Servicio servicio, Factura factura) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.servicio = servicio;
        this.factura = factura;
    }

    // Inicio - Sección de Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    // Fin - Sección de Getters y Setters
    
}
