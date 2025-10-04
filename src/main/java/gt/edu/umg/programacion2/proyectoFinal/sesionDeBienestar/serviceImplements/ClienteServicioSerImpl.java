/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Cliente;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.ClienteServicio;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Servicio;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.ClienteRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.ClienteServicioRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.ServicioRepository;
import jakarta.transaction.Transactional;
import java.math.BigInteger;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */

@Service
public class ClienteServicioSerImpl{

    @Autowired
    private ClienteServicioRepository clienteServRepo;
    
    @Autowired
    private ClienteRepository clienteRepo;
    
    @Autowired
    private ServicioRepository servicioRepo;
    
    @Transactional
    public void asignarServicioACliente(BigInteger clienteDpi, String servicioCodigo){
        // Búsqueda entre las entidades principales
        Cliente cliente = clienteRepo.findById(clienteDpi)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Servicio servicio = servicioRepo.findById(servicioCodigo)
            .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        
        // Creación de la entidad de la relación
        ClienteServicio nuevoContrato = new ClienteServicio();
        nuevoContrato.setCliente(cliente);
        nuevoContrato.setServicio(servicio);
        nuevoContrato.setFechaSuscripcion(LocalDate.now());
        
        // Guardamos la relación explicitamente
        clienteServRepo.save(nuevoContrato);
    }
    
}
