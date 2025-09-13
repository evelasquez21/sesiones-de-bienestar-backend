/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author eduar
 */
public class Cliente extends Usuario{
    private ArrayList<Servicio> listaServicios = new ArrayList<>();
    private ArrayList<Factura> listaFcturas = new ArrayList<>();
    
    // Constructor de clase
    public Cliente(String correo, String contrasena, BigInteger dpi, String nombreCompleto, String direccion, LocalDate fechaNacimiento, int telefono) {
        super(correo, contrasena, dpi, nombreCompleto, direccion, fechaNacimiento, telefono);
    }

    
    // Inicio - Sección de Getters y Setters
    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public ArrayList<Factura> getListaFcturas() {
        return listaFcturas;
    }

    public void setListaFcturas(ArrayList<Factura> listaFcturas) {
        this.listaFcturas = listaFcturas;
    }
    
    // Fin - Sección de Getters y Setters
    
    
    
}
