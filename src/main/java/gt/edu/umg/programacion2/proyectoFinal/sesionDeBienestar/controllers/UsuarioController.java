/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.RegistroPeticionDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.UsuarioDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.UsuarioRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 *
 * @author eduar
 */

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioServiceImpl usuarioService;
    
    @Autowired
    private UsuarioRepository usuarioRepo;
    
    // Endpoint - leer
    @GetMapping
    public UsuarioDTO obtenerUsuarioActual(){
        Usuario usuarioActual = getUsuarioActual();
        return usuarioService.obtenerUsuarioAcutal(usuarioActual);
    }
    
    // Endpoint - buscar por id
    @GetMapping("/{dpi}")
    public ResponseEntity<Usuario> obtenerPorDpi(@PathVariable BigInteger dpi) {
        return usuarioService.obtenerUsuarioPorDpi(dpi)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Endpoint - crear
    @PostMapping("/register")
    public ResponseEntity<?> registrarCliente(@Valid @RequestBody RegistroPeticionDTO registroPeticion){
        try {
            usuarioService.registrarUsuario(registroPeticion);
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Usuario creado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
        }
    }
    
    // Endpoint - eliminar
    @DeleteMapping("/{dpi}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable BigInteger dpi){
        return usuarioService.obtenerUsuarioPorDpi(dpi)
                .map(usuario -> {
                    usuarioService.eliminarUsuario(dpi);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Endpoint - actualizar
    @PutMapping("/{dpi}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable BigInteger dpi, @RequestBody Usuario detallesUsuario){
        return usuarioService.obtenerUsuarioPorDpi(dpi)
                .map(usuarioExistente -> {
                    usuarioExistente.setContrasena(detallesUsuario.getContrasena());
                    return ResponseEntity.ok(usuarioService.guardarUsuario(usuarioExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Método para obtener el usuario actual autenticado
    private Usuario getUsuarioActual(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDatails = (UserDetails) authentication.getPrincipal();
        return usuarioRepo.findByCorreo(userDatails.getUsername())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
   
   
