/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.EmpleadoDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.EmpleadoPanelDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Empleado;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.UsuarioRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements.EmpleadoServiceImpl;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    private EmpleadoServiceImpl empleadoService;
    
    // Endpoint - crear
    @PostMapping("/{dpi}")
    public ResponseEntity<?> asignarEmpleado(@PathVariable BigInteger dpi, @RequestBody EmpleadoDTO empleadoDTO){
        try {
            empleadoService.asignarEmpleado(dpi, empleadoDTO);
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Empleado asignado");
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
        }
    }
    
    // panel de empleado
    @GetMapping("/panel")
    public ResponseEntity<EmpleadoPanelDTO> verPanelEmpleado() {
        // Obtener al empleado actual
        EmpleadoPanelDTO panelDTO = empleadoService.obtenerPanelEmpleado();
            
        return ResponseEntity.ok(panelDTO);
    }
}
