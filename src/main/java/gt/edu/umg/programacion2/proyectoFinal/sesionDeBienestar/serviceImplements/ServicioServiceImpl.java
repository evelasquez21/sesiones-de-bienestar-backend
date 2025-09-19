/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Servicio;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.ServicioRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.ServicioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */

@Service
public class ServicioServiceImpl implements ServicioService{
    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> obtenerTodoServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Optional<Servicio> obtenerServicioPorCodigo(String codigo) {
        return servicioRepository.findById(codigo);
    }

    @Override
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public void eliminarServicio(String codigo) {
        servicioRepository.deleteById(codigo);
    }
    
    
}
