/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.AuditListener;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduar
 */

@Entity
@EntityListeners(AuditListener.class)
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "fechaEmision", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fechaEmision;
    
    @Column(name = "total")
    private double total;
    
    @Column(name = "estado")
    private boolean estado;
    
    // Relación de muchos a muchos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_dpi")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cliente cliente;
    
    // Relación de uno a muchos
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detallesFac = new ArrayList<>();

    // Constructor de clase
    public Factura() {
        
    }
    
    // Inicio - Sección de Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetallesFac() {
        return detallesFac;
    }

    public void setDetallesFac(List<DetalleFactura> detallesFac) {
        this.detallesFac.clear();
        if (detallesFac != null){
            for (DetalleFactura detalle : detallesFac){
                addDetalle(detalle);
            }
        }
    }
    
    // Fin - Sección de Getters y Setters

    // Métodos de ayuda - contructor
    public void addDetalle(DetalleFactura detalle){
        this.detallesFac.add(detalle);
        detalle.setFactura(this);
    }
    
    public void removeDetalle(DetalleFactura detalle){
        this.detallesFac.remove(detalle);
        detalle.setFactura(null);
    }
    
}
