/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.CitaRespuestaDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ClienteDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ClienteResumenDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ServicioDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ServicioResumenDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Cita;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Cliente;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.ClienteServicio;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Servicio;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.CitaRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.ClienteServicioRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduar
 */

@Service
public class CitaServiceImpl {
    
    @Autowired
    private CitaRepository citaRepo;
    
    @Autowired
    private ClienteServicioRepository clienteServRepo;
    
    @Autowired
    NotificacionServiceImpl notificacionService;
    
    @Transactional
    public Cita programarCita(Long clienteServicioId, LocalDateTime fechaHora){
            // Búsqueda de la asignación del servicio con el cliente
            ClienteServicio asignacion = clienteServRepo.findById(clienteServicioId)
                    .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
            
            // Crear la instancia de Cita
            Cita nuevaCita = new Cita();
            nuevaCita.setFechaHora(fechaHora);
            nuevaCita.setEstado(1);
            
            // Vinculación del contrato con la cita
            nuevaCita.setClienteServicio(asignacion);
            
            // Notificacion de cita al usuario
            Usuario usuarioANotificar = nuevaCita.getClienteServicio().getCliente();
            DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String mensaje = "Tu cita ha sido programada para el servicio: " +
                nuevaCita.getClienteServicio().getServicio().getNombre() +
                " agendada para el " + fechaHora.format(fechaFormato);
            notificacionService.crearNotificacion(usuarioANotificar, mensaje);
            return citaRepo.save(nuevaCita);
    }
    
    @Transactional(readOnly = true)
    public List<CitaRespuestaDTO> obtenerTodasLasCitas(){
        return citaRepo.findAll().stream()
            .map(this::convertirADto)
            .collect(Collectors.toList());
    }
    
    // Método para convertir a DTO
    private CitaRespuestaDTO convertirADto(Cita cita){
        // Relaciones entre entidades
        Cliente cliente = cita.getClienteServicio().getCliente();
        Servicio servicio = cita.getClienteServicio().getServicio();
        
        // Creación de DTO's
        ClienteResumenDTO clienteDTO = new ClienteResumenDTO();
        clienteDTO.setDpi(cliente.getDpi());
        clienteDTO.setNombreCompleto(cliente.getNombreCompleto());
        
        ServicioResumenDTO servicioDTO = new ServicioResumenDTO();
        servicioDTO.setCodigo(servicio.getCodigo());
        servicioDTO.setNombre(servicio.getNombre());
        
        // Creación del DTO principal
        CitaRespuestaDTO citaRespuestaDTO = new CitaRespuestaDTO();
        citaRespuestaDTO.setId(cita.getId());
        citaRespuestaDTO.setFechaHora(cita.getFechaHora());
        citaRespuestaDTO.setEstado(cita.getEstado());
        citaRespuestaDTO.setCliente(clienteDTO);
        citaRespuestaDTO.setServicio(servicioDTO);
        
        return citaRespuestaDTO;
    }
}
