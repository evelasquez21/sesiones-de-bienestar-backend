/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.CitaPeticionDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.CitaRespuestaDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Cita;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements.CitaServiceImpl;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduar
 */
@RestController
@RequestMapping("/api/citas")
public class CitaController {
    
    @Autowired
    private CitaServiceImpl citaServiceImpl;
    
     // Endpoint - crear
    @PostMapping
    public ResponseEntity<String> programarCita(@RequestBody CitaPeticionDTO citaPeticion){
        try {
            Cita nuevaCita = citaServiceImpl.programarCita(
                    citaPeticion.getClienteServicioId(),
                    citaPeticion.getFechaHora()
            );
            
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Cita programada");
        } catch (RuntimeException e) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<List<CitaRespuestaDTO>> obtenerCitas(){
        List<CitaRespuestaDTO> citas = citaServiceImpl.obtenerTodasLasCitas();
        return ResponseEntity.ok(citas);
    }
    
}
