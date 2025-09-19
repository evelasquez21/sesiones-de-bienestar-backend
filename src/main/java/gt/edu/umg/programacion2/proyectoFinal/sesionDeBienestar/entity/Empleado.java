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
public class Empleado extends Usuario{
    
    // Constructor de clase
    public Empleado(String correo, String contrasena, BigInteger dpi, String nombreCompleto, String direccion, LocalDate fechaNacimiento, int telefono) {
        super(correo, contrasena);
    }
    
}
