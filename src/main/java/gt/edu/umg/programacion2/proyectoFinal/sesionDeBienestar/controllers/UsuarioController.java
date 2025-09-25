/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.UsuarioService;
import java.math.BigInteger;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 *
 * @author eduar
 */

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    // Endpoint - leer
    @GetMapping
    public List<Usuario> obtenerTodoLosUsuarios(){
        return usuarioService.obtenerTodoLosUsuarios();
    }
    
    // Endpoint - buscar por id
    @GetMapping("/{dpi}")
    public ResponseEntity<Usuario> obtenerPorDpi(@PathVariable BigInteger dpi) {
        return usuarioService.obtenerUsuarioPorDpi(dpi)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Endpoint - crear
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
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
}
   
   
