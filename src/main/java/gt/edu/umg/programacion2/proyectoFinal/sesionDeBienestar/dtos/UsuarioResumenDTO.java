/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos;

import java.math.BigInteger;

/**
 *
 * @author eduar
 */
public class UsuarioResumenDTO {
    private BigInteger dpi;
    private String nombreCompleto;
    private String correo;

    // Constructor de clase
    public UsuarioResumenDTO() {
    }

    // Inicio - Sección de Getters y Setters
    public BigInteger getDpi() {
        return dpi;
    }

    public void setDpi(BigInteger dpi) {
        this.dpi = dpi;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    // Fin - Sección de Getters y Setters
}
