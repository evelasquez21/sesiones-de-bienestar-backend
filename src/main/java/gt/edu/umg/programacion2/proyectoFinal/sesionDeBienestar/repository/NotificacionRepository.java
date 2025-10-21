/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Notificacion;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long>{
    List<Notificacion> findByUsuarioOrderByFechaEnvioDesc(Usuario usuario);
}
