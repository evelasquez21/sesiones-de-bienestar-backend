/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.components.BeanUtil;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.HistorialCambios;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Persona;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.HistorialCambiosRepository;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author eduar
 */
public class AuditListener {
    
    @PrePersist
    public void auditCreate(Object entidad){
        registrarCambio(entidad, "Creación");
    }
    
    @PreUpdate
    public void auditUpdate(Object entidad){
        registrarCambio(entidad, "Modificación");
    }
    
    private void registrarCambio(Object entidad, String accion) {
        try {
            // Método estático para obtener el repositorio
            HistorialCambiosRepository repo = BeanUtil.getBean(HistorialCambiosRepository.class);
            
            HistorialCambios historial = new HistorialCambios();
            historial.setEntidad(entidad.getClass().getSimpleName());
            historial.setAccion(accion);
            historial.setUsuario(obtenerUsuarioActual());
            
            repo.save(historial);
            
        } catch (Exception e) {
            // Manejo de excepción.
            e.printStackTrace();
        }
        
        
    }
    
    private String obtenerUsuarioActual(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
            
        return "Anónimo";
    }
}
