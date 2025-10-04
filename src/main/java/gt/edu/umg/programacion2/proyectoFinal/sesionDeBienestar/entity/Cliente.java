/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author eduar
 */

@Entity
public class Cliente extends Usuario{
    // Relación de Muchos a muchos
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ClienteServicio> serviciosContratados = new HashSet<>();
    
    // Relación de uno a muchos
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> listaFacturas = new ArrayList<>();
    
    // Constructor de clase

    public Cliente() {
    }
    
    // Inicio - Sección de Getters y Setters
    public Set<ClienteServicio> getServiciosContradados() {
        return serviciosContratados;
    }

    public void setServiciosContradados(Set<ClienteServicio> serviciosContradados) {
        this.serviciosContratados = serviciosContradados;
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
    
    // Fin - Sección de Getters y Setters
    
}
