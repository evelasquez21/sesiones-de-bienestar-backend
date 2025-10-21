/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ServicioDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Servicio;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements.ServicioServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/servicios")
public class ServicioController {
    
    @Autowired
    private ServicioServiceImpl servicioService;
    
    // Endpoint - leer
    @GetMapping("/lista")
    public List<Servicio> obtenerTodosLosServicios(){
        return servicioService.obtenerTodoServicios();
    }
    
    // Endpoint - buscar por id
    @GetMapping("/{codigo}")
    public ResponseEntity<Servicio> obtenerPorCodigo(@PathVariable String codigo){
        return servicioService.obtenerServicioPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Endpoint - crear
    @PostMapping("/nuevo")
    public ResponseEntity<String> programarCita(@RequestBody ServicioDTO servicioDTO){
        try {
            Servicio nuevoServicio = servicioService.crearNuevoServicio(servicioDTO);
            
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Servicio creado");
        } catch (RuntimeException e) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
        }
    }
    
    // Endpoint - eliminar
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String codigo){
        return servicioService.obtenerServicioPorCodigo(codigo)
                .map(servicio -> {
                    servicioService.eliminarServicio(codigo);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
