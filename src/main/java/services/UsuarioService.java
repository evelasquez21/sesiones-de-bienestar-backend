/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.math.BigInteger;
import java.time.LocalDate;
import models.Usuario;

/**
 *
 * @author eduar
 */
public class UsuarioService {
    public void registrarusuario(String correo, String contrasena, BigInteger dpi, String nombreCompleto, String direccion, LocalDate fechaNacimiento, int telefono){
        Usuario u1 = new Usuario(correo, contrasena, dpi, nombreCompleto, direccion, fechaNacimiento, telefono);
    }
}
