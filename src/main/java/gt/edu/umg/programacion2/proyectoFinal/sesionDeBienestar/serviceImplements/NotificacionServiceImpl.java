/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.NotificacionDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.UsuarioResumenDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Notificacion;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.NotificacionRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduar
 */

@Service
public class NotificacionServiceImpl {
    
    @Autowired
    private NotificacionRepository notificacionRepo;
    
    // Método para crear notificación
    @Transactional
    public void crearNotificacion(Usuario usuario, String mensaje) {
        Notificacion notificacion = new Notificacion();
        notificacion.setUsuario(usuario);
        notificacion.setMensaje(mensaje);
        notificacion.setEstado(false);
        notificacion.setFechaEnvio(LocalDateTime.now());
        notificacionRepo.save(notificacion);
    }
    
    // Método de lista de notificaciones
    @Transactional
    public List<NotificacionDTO> obtenerMisNotis(Usuario usuario){
        return notificacionRepo.findByUsuarioOrderByFechaEnvioDesc(usuario).stream()
            .map(this::convertirADto)
            .collect(Collectors.toList());
    }
    
    // Convertir entidad a DTO
    private NotificacionDTO convertirADto(Notificacion notificacion){
        // Relación
        Usuario usuario = notificacion.getUsuario();
        
        // Creación de DTO relación
        UsuarioResumenDTO usuarioDTO = new UsuarioResumenDTO();
        usuarioDTO.setDpi(usuario.getDpi());
        usuarioDTO.setNombreCompleto(usuario.getNombreCompleto());
        usuarioDTO.setCorreo(usuario.getCorreo());
        
        // Creación DTO principal
        NotificacionDTO notificacionDTO = new NotificacionDTO();
        notificacionDTO.setId(notificacion.getId());
        notificacionDTO.setMensaje(notificacion.getMensaje());
        notificacionDTO.setEstado(notificacion.isEstado());
        notificacionDTO.setFechaEnvio(notificacion.getFechaEnvio());
        notificacionDTO.setUsuario(usuarioDTO);
        
        return notificacionDTO;
    } 
}
