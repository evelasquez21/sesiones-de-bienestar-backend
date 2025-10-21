/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.NotificacionDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Notificacion;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.NotificacionRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.UsuarioRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements.NotificacionServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduar
 */

@RestController
@RequestMapping("/api/notificaciones")
public class Notificacioncontroller {
    
    @Autowired
    private NotificacionRepository notificacionRepo;
    
    @Autowired
    private NotificacionServiceImpl notificacionService;
    
    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @GetMapping
    public List<NotificacionDTO> getMisNotificaciones() {
        Usuario usuarioActual = getUsuarioActual();
        return notificacionService.obtenerMisNotis(usuarioActual);
    }
    
    @PostMapping("/{id}/marcar-leido")
    public ResponseEntity<?> marcarComoLeido(@PathVariable Long id){
        Usuario usuarioActual = getUsuarioActual();
        Notificacion notificacion = notificacionRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        
        // Verificacion de seguridad
        if (!notificacion.getUsuario().getDpi().equals(usuarioActual.getDpi())){
            return ResponseEntity.status(403).body("No tienes permiso para modificar esta notificacion");
        }
        
        notificacion.setEstado(true);
        notificacionRepo.save(notificacion);
        return ResponseEntity.ok().build();
    }
    
    // Método para obtener el usuario actual autenticado
    private Usuario getUsuarioActual(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDatails = (UserDetails) authentication.getPrincipal();
        return usuarioRepo.findByCorreo(userDatails.getUsername())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
