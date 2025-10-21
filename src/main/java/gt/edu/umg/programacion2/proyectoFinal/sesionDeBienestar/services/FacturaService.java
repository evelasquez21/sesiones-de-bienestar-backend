/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Factura;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author eduar
 */
public interface FacturaService {
    List<Factura> obtenerTodasLasFacturas();
    Optional<Factura> obtenerFacturaPorId(Long id);
    Factura guardarFactura(Factura factura);
    void eliminarFactura(Long id);
}
