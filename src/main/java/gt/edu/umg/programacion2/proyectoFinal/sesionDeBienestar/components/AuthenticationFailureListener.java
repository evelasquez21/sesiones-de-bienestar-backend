/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.components;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements.IntentosDeSesionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author eduar
 */
@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent>{

    @Autowired
    private IntentosDeSesionServiceImpl intentoSesionService;
    
    // Método de validación de autentificación
    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        System.out.println("Se esta implementando el AutenticationFailure");
        String correo = (String) event.getAuthentication().getPrincipal();
        intentoSesionService.SesionFallida(correo);
    }
    
}
