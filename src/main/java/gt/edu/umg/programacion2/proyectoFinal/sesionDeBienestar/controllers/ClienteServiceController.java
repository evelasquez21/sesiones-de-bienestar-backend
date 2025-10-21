/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ClienteServicioDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements.ClienteServicioSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduar
 */

@RestController
@RequestMapping("/api/asignar-servicio")
public class ClienteServiceController {
    
    @Autowired
    private ClienteServicioSerImpl clienteSServiceImpl;
    
     // Endpoint - crear
    @PostMapping
    public ResponseEntity<String> asignarServicio(@RequestBody ClienteServicioDTO clienteServicioDTO){
        try{
            clienteSServiceImpl.asignarServicioACliente(clienteServicioDTO.getClienteDpi(), clienteServicioDTO.getServicioCodigo());
            
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Servicio asignado al cliente");
        } catch (RuntimeException e){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
        }
    }
    
    
}
