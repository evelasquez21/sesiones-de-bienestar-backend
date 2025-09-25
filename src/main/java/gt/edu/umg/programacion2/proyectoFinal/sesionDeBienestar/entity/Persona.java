/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author eduar
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {
    
    // Atributos de clase
    @Id
    @Column(name = "dpi")
    private BigInteger dpi;
    
    @Column(name ="nombreCompleto")
    private String nombreCompleto;
    
    @Column(name ="direccion")
    private String direccion;
    
    @Column(name = "fechaNacimiento", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;
    
    @Column(name ="telefono")
    private int telefono;

    
    // Constructor de clase
    public Persona() {
    }

    public Persona(BigInteger dpi, String nombreCompleto, String direccion, LocalDate fechaNacimiento, int telefono) {
        this.dpi = dpi;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }
    
    

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
    
    // Inicio Métodos equals y hashcode
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return  false;
        Persona persona = (Persona) o;
        return getDpi() != null && getDpi().equals(persona.getDpi());
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), dpi);
    }
    
    // Final Métodos equals y hashcode
}
