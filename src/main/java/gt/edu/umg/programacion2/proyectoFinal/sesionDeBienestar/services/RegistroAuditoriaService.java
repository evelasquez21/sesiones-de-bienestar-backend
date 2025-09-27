/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.RegistroAuditoria;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author eduar
 */
public interface RegistroAuditoriaService {
    List<RegistroAuditoria> obtenerTodoRegAudi();
    Optional<RegistroAuditoria> obtenerRegAudiPorId(Long id);
    RegistroAuditoria guardarRegAudi(RegistroAuditoria regAudi);
    void eliminarServicio(Long id);
}
