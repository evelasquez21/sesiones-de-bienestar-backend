/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 *
 * @author eduar
 */
public class Administrador extends Empleado{
    
    // Constructor de clase
    public Administrador(String correo, String contrasena, BigInteger dpi, String nombreCompleto, String direccion, LocalDate fechaNacimiento, int telefono) {
        super(correo, contrasena, dpi, nombreCompleto, direccion, fechaNacimiento, telefono);
    }
    
}
