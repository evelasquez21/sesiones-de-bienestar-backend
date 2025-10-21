/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ClienteCreacionDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ClienteDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements.ClienteServiceImpl;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduar
 */

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;
    
     // Endpoint - leer
    @GetMapping
    public List<ClienteDTO> obtenerTodos(){
        return clienteServiceImpl.obtenerTodosClienteDTO();
    }
    
     // Endpoint - buscar por id
    @GetMapping("/{dpi}")
    public ResponseEntity<ClienteDTO> obtenerPorDPI(@PathVariable BigInteger dpi){
        return ResponseEntity.ok(clienteServiceImpl.obtenerClienteComoDTO(dpi));
    }
    
    // Endpoint - crear
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO crearCliente(@RequestBody ClienteCreacionDTO clienteDTO){
        return clienteServiceImpl.creaClienteDTO(clienteDTO);
    }
}