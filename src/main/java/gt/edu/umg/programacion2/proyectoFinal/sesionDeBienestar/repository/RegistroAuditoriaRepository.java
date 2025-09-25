/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.RegistroAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */

@Repository
public interface RegistroAuditoriaRepository extends JpaRepository<RegistroAuditoria, Long>{
    
}
