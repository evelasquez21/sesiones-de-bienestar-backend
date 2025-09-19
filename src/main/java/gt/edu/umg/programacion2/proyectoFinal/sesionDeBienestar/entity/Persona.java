/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.math.BigInteger;
import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author eduar
 */


@MappedSuperclass
public abstract class Persona {
    
    // Atributos de clase
    @Id
    @Column(name = "dpi")
    private BigInteger dpi;
    
    @Column(name ="nombreCompleto")
    private String nombreCompleto;
    
    @Column(name ="direccion")
    private String direccion;
    
    @CreationTimestamp
    @Column(name = "fechaNacimiento", updatable = false)
    private LocalDate fechaNacimiento;
    
    @Column(name ="telefono")
    private int telefono;

    // Inicio - Sección de Getters y Setters
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
    
    // Fin - Sección de Getters y Setters
    
}
