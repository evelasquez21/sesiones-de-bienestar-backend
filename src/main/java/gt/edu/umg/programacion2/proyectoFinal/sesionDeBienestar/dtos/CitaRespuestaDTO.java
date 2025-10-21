/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

/**
 *
 * @author eduar
 */
public class CitaRespuestaDTO {
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaHora;
    private int estado;
    
    // Objetos DTO
    private ServicioResumenDTO servicio;
    private ClienteResumenDTO cliente;

    // Inicio - Sección de Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public ServicioResumenDTO getServicio() {
        return servicio;
    }

    public void setServicio(ServicioResumenDTO servicio) {
        this.servicio = servicio;
    }

    public ClienteResumenDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResumenDTO cliente) {
        this.cliente = cliente;
    }
    
    // Fin - Sección de Getters y Setters
    
    
}
