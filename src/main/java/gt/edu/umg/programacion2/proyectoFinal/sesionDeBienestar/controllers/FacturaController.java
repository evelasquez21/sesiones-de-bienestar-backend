/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Factura;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduar
 */
@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    
    @Autowired
    private FacturaService facturaService;
    
    // Endpoint - leer
    @GetMapping
    public List<Factura> obtenerTodoFactura(){
        return facturaService.obtenerTodasLasFacturas();
    }
    
    // Endpoint - buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerPorId(@PathVariable Long id) {
        return facturaService.obtenerFacturaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Endpoint - crear
    @PostMapping
    public Factura crearFactura(@RequestBody Factura factura){
        return facturaService.guardarFactura(factura);
    }
    
    // Endpoint - eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Long id){
        return facturaService.obtenerFacturaPorId(id)
                .map(factura -> {
                    facturaService.eliminarFactura(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
