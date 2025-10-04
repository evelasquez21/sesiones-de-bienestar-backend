/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 *
 * @author eduar
 */
public class ClienteServicioDTO {
    private BigInteger clienteDpi;
    private String servicioCodigo;
    private LocalDate fechaSuscripcion;

    public BigInteger getClienteDpi() {
        return clienteDpi;
    }

    public void setClienteDpi(BigInteger clienteDpi) {
        this.clienteDpi = clienteDpi;
    }

    public String getServicioCodigo() {
        return servicioCodigo;
    }

    public void setServicioCodigo(String servicioCodigo) {
        this.servicioCodigo = servicioCodigo;
    }

    public LocalDate getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(LocalDate fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }
    
}
