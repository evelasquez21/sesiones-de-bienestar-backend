/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.Objects;

/**
 *
 * @author eduar
 */

@Entity
public class Empleado extends Usuario{
    @Column(name = "codigo")
    private Long codigo;
    
    // Constructor de clase
    public Empleado(){
        
    }

    
    
    // Inicio - Sección de Getters y Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long carnet) {
        this.codigo = carnet;
    }
    
    // Fin - Sección de Getters y Setters
    
     // Inicio Métodos equals y hashcode
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return  false;
        Empleado empleado = (Empleado) o;
        return getCodigo() != null && getCodigo().equals(empleado.getCodigo());
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), codigo);
    }
    
    // Final Métodos equals y hashcode
}
