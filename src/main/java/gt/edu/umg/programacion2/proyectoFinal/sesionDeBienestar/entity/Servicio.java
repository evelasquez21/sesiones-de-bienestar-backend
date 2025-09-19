/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

/**
 *
 * @author eduar
 */
@Entity
public class Servicio {
    
    // Atributos de clase
    @Id
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "precio")
    private double precio;
    
    @Column(name = "duarcion")
    private int duracion;
    
    @Column(name = "maxConcurrentes")
    private int maxConcurrentes;
    
    @Column(name = "estado")
    private boolean estado;
    
    // Constructor de clase
    public Servicio() {
        
    }
    
    public Servicio(String codigo, String nombre, double precio, int duracion, int maxConcurrentes, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;
        this.maxConcurrentes = maxConcurrentes;
        this.estado = estado;
    }
    
    // Inicio - Sección de Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getMaxConcurrentes() {
        return maxConcurrentes;
    }

    public void setMaxConcurrentes(int maxConcurrentes) {
        this.maxConcurrentes = maxConcurrentes;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    // Fin - Sección de Getters y Setters
    
    // Inicio Métodos equals y hashcode
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return  false;
        Servicio servicio = (Servicio) o;
        return Objects.equals(codigo, servicio.getCodigo()) && Objects.equals(nombre, servicio.getNombre());
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(codigo, nombre, precio, duracion, maxConcurrentes, estado);
    }
    
    // Final Métodos equals y hashcode
}
