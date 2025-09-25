/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Empleado;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.EmpleadoRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.EmpleadoService;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> obtenerTodoEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> obtenerEmpleadoDpi(BigInteger dpi) {
        return empleadoRepository.findById(dpi);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(BigInteger dpi) {
        empleadoRepository.deleteById(dpi);
    }
    
    
}
