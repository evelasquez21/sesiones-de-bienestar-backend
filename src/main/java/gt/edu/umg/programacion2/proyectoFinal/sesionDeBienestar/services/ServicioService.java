/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Servicio;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author eduar
 */
public interface ServicioService {
    List<Servicio> obtenerTodoServicios();
    Optional<Servicio> obtenerServicioPorCodigo(String codigo);
    Servicio guardarServicio(Servicio servicio);
    void eliminarServicio(String codigo);
}
