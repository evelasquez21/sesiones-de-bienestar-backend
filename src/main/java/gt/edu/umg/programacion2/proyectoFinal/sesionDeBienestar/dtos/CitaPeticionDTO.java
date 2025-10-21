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
public class CitaPeticionDTO {
    private Long clienteServicioId;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaHora;
   

    // Inicio - Sección de Getters y Setters
    public Long getClienteServicioId() {
        return clienteServicioId;
    }

    public void setClienteServicioId(Long clienteServicioId) {
        this.clienteServicioId = clienteServicioId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    // Fin - Sección de Getters y Setters
    
}
