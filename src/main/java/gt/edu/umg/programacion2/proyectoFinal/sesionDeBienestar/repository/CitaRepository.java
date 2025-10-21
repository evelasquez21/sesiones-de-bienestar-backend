/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Cita;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */
@Repository
public interface CitaRepository extends JpaRepository<Cita, Long>{
    Optional<Cita> findByClienteServicioId(Long clienteServicio_id);
}
