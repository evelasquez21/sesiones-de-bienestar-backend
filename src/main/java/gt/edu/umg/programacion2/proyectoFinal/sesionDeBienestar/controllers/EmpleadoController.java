/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Empleado;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.EmpleadoService;
import java.math.BigInteger;
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
@RequestMapping("/api/empleados")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
     // Endpoint - leer
    @GetMapping
    public List<Empleado> obtenerTodoEmpleado(){
        return empleadoService.obtenerTodoEmpleado();
    }
    
    // Endpoint - buscar por id
    @GetMapping("/{dpi}")
    public ResponseEntity<Empleado> obtenerPorCodgio(@PathVariable BigInteger dpi) {
        return empleadoService.obtenerEmpleadoDpi(dpi)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Endpoint - crear
    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado){
        return empleadoService.guardarEmpleado(empleado);
    }
    
    // Endpoint - eliminar
    @DeleteMapping("/{dpi}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable BigInteger dpi){
        return empleadoService.obtenerEmpleadoDpi(dpi)
                .map(empleado -> {
                    empleadoService.eliminarEmpleado(dpi);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
