/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Factura;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.FacturaRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.FacturaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */

@Service
public class FacturaServiceImpl implements FacturaService{
    
    @Autowired
    private FacturaRepository facturaRepo;

    @Override
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepo.findAll();
    }

    @Override
    public Optional<Factura> obtenerFacturaPorId(Long id) {
        return facturaRepo.findById(id);
    }

    @Override
    public Factura guardarFactura(Factura factura) {
        return facturaRepo.save(factura);
    }

    @Override
    public void eliminarFactura(Long id) {
        facturaRepo.deleteById(id);
    }
    
}
