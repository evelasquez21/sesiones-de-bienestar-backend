/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Empleado;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author eduar
 */
public interface EmpleadoService {
    List<Empleado> obtenerTodoEmpleado();
    Optional<Empleado> obtenerEmpleadoDpi(BigInteger dpi);
    Empleado guardarEmpleado(Empleado empleado);
    void eliminarEmpleado(BigInteger dpi);
}
