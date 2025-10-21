/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ClienteCreacionDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ClienteDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.ClienteServicioDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.FacturaDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.RegistroPeticionDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Cliente;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */

@Service
public class ClienteServiceImpl{

    @Autowired
    private ClienteRepository clienteRepo;
    
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    
    @Transactional
    public ClienteDTO obtenerClienteComoDTO(BigInteger dpi){
        Cliente cliente = clienteRepo.findById(dpi).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return convertirAClienteDTO(cliente);
    }
    
    @Transactional
    public List<ClienteDTO> obtenerTodosClienteDTO(){
        return clienteRepo.findAll().stream()
            .map(this::convertirAClienteDTO)
            .collect(Collectors.toList());
    }
    
    @Transactional
    public ClienteDTO creaClienteDTO(ClienteCreacionDTO clienteDTO){
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setDpi(clienteDTO.getDpi());
        nuevoCliente.setNombreCompleto(clienteDTO.getNombreCompleto());
        nuevoCliente.setDireccion(clienteDTO.getDireccion());
        nuevoCliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        nuevoCliente.setTelefono(clienteDTO.getTelefono());
        nuevoCliente.setCorreo(clienteDTO.getCorreo());
        nuevoCliente.setContrasena(clienteDTO.getContrasena());
        
        Cliente clienteGuardado = clienteRepo.save(nuevoCliente);
        return convertirAClienteDTO(clienteGuardado);
    }
    
    public Cliente registrarCliente(RegistroPeticionDTO registroPeticion){
        if (clienteRepo.findByCorreo(registroPeticion.getCorreo()).isPresent()){
            throw new RuntimeException("El correco electrónico ya está en uso");
        } else if(clienteRepo.findById(registroPeticion.getDpi()).isPresent()){
            throw new RuntimeException("El número de DPI ya está registrado");
        }
        
        
        Cliente nuevoCliente = new Cliente();
        
        nuevoCliente.setDpi(registroPeticion.getDpi());
        nuevoCliente.setNombreCompleto(registroPeticion.getNombreCompleto());
        nuevoCliente.setDireccion(registroPeticion.getDireccion());
        nuevoCliente.setFechaNacimiento(registroPeticion.getFechaNacimiento());
        nuevoCliente.setTelefono(registroPeticion.getTelefono());
        nuevoCliente.setCorreo(registroPeticion.getCorreo());
        
        nuevoCliente.setContrasena(passwordEncoder.encode(registroPeticion.getContrasena()));
        nuevoCliente.setCuentaBloqueada(false);
        
        return clienteRepo.save(nuevoCliente);
    }
    
    private ClienteDTO convertirAClienteDTO(Cliente cliente){
        // Mapeo manual
        ClienteDTO dto = new ClienteDTO();
        dto.setDpi(cliente.getDpi());
        dto.setNombreCompleto(cliente.getNombreCompleto());
        dto.setDireccion(cliente.getDireccion());
        dto.setFechaNacimiento(cliente.getFechaNacimiento());
        dto.setTelefono(cliente.getTelefono());
        dto.setCorreo(cliente.getCorreo());
        dto.setContrasena(cliente.getContrasena());
        
        if (cliente.getServiciosContradados() !=null){
            List<ClienteServicioDTO> clienteServiciosDTO = cliente.getServiciosContradados().stream()
                .map(clienteServicio -> {
                    ClienteServicioDTO clienteServicioDTO = new ClienteServicioDTO();
                    clienteServicioDTO.setClienteDpi(clienteServicio.getCliente().getDpi());
                    clienteServicioDTO.setServicioCodigo(clienteServicio.getServicio().getCodigo());
                    clienteServicioDTO.setFechaSuscripcion(clienteServicio.getFechaSuscripcion());
                    return clienteServicioDTO;
                }).collect(Collectors.toList());
            dto.setServicios(clienteServiciosDTO);
        }
        
        if (cliente.getListaFacturas() != null){
            List<FacturaDTO> facturasDTO = cliente.getListaFacturas().stream()
                .map(factura -> {
                    FacturaDTO facturaDTO = new FacturaDTO();
                    facturaDTO.setId(factura.getId());
                    facturaDTO.setFechaEmision(factura.getFechaEmision());
                    facturaDTO.setEstado(factura.isEstado());
                    facturaDTO.setTotal(factura.getTotal());
                    return facturaDTO;
                }).collect(Collectors.toList());

            dto.setFacturas(facturasDTO);
        }
        return dto;
    }
    
}
