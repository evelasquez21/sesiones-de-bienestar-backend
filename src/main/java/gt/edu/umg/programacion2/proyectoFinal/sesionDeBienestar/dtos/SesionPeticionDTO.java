/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author eduar
 */
public class SesionPeticionDTO {
    @NotBlank(message = "El correo eléctronico no puede estar vacío")
    @Email(message = "El formato del correo electrónico no es válido")
    private String correo;
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 16, message = "La contraseña debe de tener entre 8 y 16 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=!]).*$", message = "La contraseña debe de contener al menos una mayúscula y un carácter especial")
    private String contrasena;
    
    // Inicio - Sección de Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String corre) {
        this.correo = corre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    // Fin - Sección de Getters y Setters
    
}
