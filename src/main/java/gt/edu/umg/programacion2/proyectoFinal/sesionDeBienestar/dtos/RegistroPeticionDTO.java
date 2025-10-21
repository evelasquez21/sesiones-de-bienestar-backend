/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.math.BigInteger;
import java.time.LocalDate;

/**
 *
 * @author eduar
 */
public class RegistroPeticionDTO {
    private BigInteger dpi;
    private String nombreCompleto;
    private String direccion;
    
    @Column(name = "fechaNacimiento", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;
    
    private int telefono;
    
    @NotBlank(message = "El correo eléctronico no puede estar vacío")
    @Email(message = "El formato del correo electrónico no es válido")
    private String correo;
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 16, message = "La contraseña debe de tener entre 8 y 16 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=!]).*$", message = "La contraseña debe de contener al menos una mayúscula y un carácter especial")
    private String contrasena;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
