/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eduar
 */
public class ClienteDTO {
    private BigInteger dpi;
    private String nombreCompleto;
    private String direccion;
    private LocalDate fechaNacimiento;
    private int telefono;
    private String correo;
    private String contrasena;
    
    private List<ClienteServicioDTO> servicios;
    private List<FacturaDTO> facturas;

    public BigInteger getDpi() {
        return dpi;
    }

    public void setDpi(BigInteger dpi) {
        this.dpi = dpi;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<ClienteServicioDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ClienteServicioDTO> servicios) {
        this.servicios = servicios;
    }
    
    public List<FacturaDTO> getFacturas(){
        return facturas;
    }
    
    public void setFacturas(List<FacturaDTO> facturas){
        this.facturas = facturas;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
