/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.EmpleadoDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.EmpleadoPanelDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Empleado;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.EmpleadoRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.UsuarioRepository;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduar
 */
@Service
public class EmpleadoServiceImpl{
    @Autowired
    private EmpleadoRepository empleadoRepo;
    
    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Transactional(readOnly = true)
    public EmpleadoPanelDTO obtenerPanelEmpleado(){
        // Autentificación de información
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        // Búsqueda del usuario
        Usuario usuario = usuarioRepo.findByCorreo(userDetails.getUsername())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        // Obtener el perfil del empleado
        Empleado empleado = usuario.getPerfilEmpleado();
        
        // Validación de perfil de usuario
        if (empleado == null){
            throw new RuntimeException("El usuario actual no es un empleado");
        }
        
        return convertirADTO(empleado);
    }
    
    
    @Transactional
    public Empleado asignarEmpleado(BigInteger dpiUsuario, EmpleadoDTO empleadoDto){
        Usuario usuario = usuarioRepo.findById(dpiUsuario)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        if (usuario.getPerfilEmpleado() != null){
            throw new IllegalStateException("Usuario ya tiene un rol de empleado");
        }
        
        // Instancia de la entidad
        Empleado nuevoEmpleado = new Empleado(); 


        // Asignación del nuevo campo
        nuevoEmpleado.setCodigo(empleadoDto.getCodigo());
        nuevoEmpleado.setRol(empleadoDto.getRol());
        
        // Asignación de relaciones
        nuevoEmpleado.setUsuario(usuario);
       
        return empleadoRepo.save(nuevoEmpleado);
    }
    
    // Convertir entidad a DTO
    private EmpleadoPanelDTO convertirADTO(Empleado empleado){
        // Creación de DTO Principal
        EmpleadoPanelDTO empleadoDTO = new EmpleadoPanelDTO();
        
        empleadoDTO.setDpi(empleado.getUsuario().getDpi());
        empleadoDTO.setCodigo(empleado.getCodigo());
        empleadoDTO.setRol(empleado.getRol());
        empleadoDTO.setNombreCompleto(empleado.getUsuario().getNombreCompleto());
        empleadoDTO.setCorreo(empleado.getUsuario().getCorreo());
        
        return empleadoDTO;
    }
}
