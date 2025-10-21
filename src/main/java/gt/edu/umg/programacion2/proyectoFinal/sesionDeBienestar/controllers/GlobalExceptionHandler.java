/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.RespuestaErrores;

/**
 *
 * @author eduar
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    // Escenario 1: Credenciales incorrectas (contraseña inválida)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<RespuestaErrores> handleBadCredentialsException(BadCredentialsException ex) {
        RespuestaErrores error = new RespuestaErrores(
            HttpStatus.UNAUTHORIZED.value(), 
            "Credenciales Inválidas", 
            "El correo o la contraseña son incorrectos."
        );
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    // Escenario 2: La cuenta está bloqueada
    @ExceptionHandler(LockedException.class)
    public ResponseEntity<RespuestaErrores> handleLockedException(LockedException ex) {
        RespuestaErrores error = new RespuestaErrores(
            HttpStatus.FORBIDDEN.value(), 
            "Cuenta Bloqueada", 
            "La cuenta ha sido bloqueada temporalmente por demasiados intentos fallidos."
        );
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    // Escenario 3: El usuario (correo) no existe
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<RespuestaErrores> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        RespuestaErrores error = new RespuestaErrores(
            HttpStatus.NOT_FOUND.value(), 
            "Usuario no Encontrado", 
            ex.getMessage() // Reutiliza el mensaje del servicio
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Escenario General: Para cualquier otra excepción no controlada
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaErrores> handleGenericException(Exception ex) {
        RespuestaErrores error = new RespuestaErrores(
            HttpStatus.INTERNAL_SERVER_ERROR.value(), 
            "Error Interno del Servidor", 
            "Ocurrió un error inesperado. Por favor, intente de nuevo más tarde."
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
