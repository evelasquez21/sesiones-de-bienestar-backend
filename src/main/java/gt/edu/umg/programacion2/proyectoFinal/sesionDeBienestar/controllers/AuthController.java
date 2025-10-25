/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.components.JwtUtil;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.RegistroPeticionDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.SesionPeticionDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements.ClienteServiceImpl;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements.IntentosDeSesionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 *
 * @author eduar
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUtil jwutil;
    
    @Autowired
    private IntentosDeSesionServiceImpl intentoSesion;
    
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;
    
    @PostMapping("/login")
    public ResponseEntity<?> autenticarUsuario(@Valid @RequestBody SesionPeticionDTO sesionPeticion){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(sesionPeticion.getCorreo(), sesionPeticion.getContrasena())
        );
        
        intentoSesion.sesionExitosa(sesionPeticion.getCorreo());
        
        final String jwt = jwutil.generarToken(sesionPeticion.getCorreo());
        
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registrarCliente(@Valid @RequestBody RegistroPeticionDTO registroPeticion){
        try {
            clienteServiceImpl.registrarCliente(registroPeticion);
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Usuario creado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
        }
    }
}

class JwtResponse {
    private String token;
    public JwtResponse(String token) { this.token = token; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}