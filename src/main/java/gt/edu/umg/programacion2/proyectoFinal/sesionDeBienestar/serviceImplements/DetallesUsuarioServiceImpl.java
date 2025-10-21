/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.UsuarioRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */

@Service
public class DetallesUsuarioServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private IntentosDeSesionServiceImpl intentosSesion;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Validación de cuenta bloqueada
        if (intentosSesion.sesionBloqueada(username)){
            throw new LockedException("Cuenta bloqueada por demasiados intentos fallidos, pruebe dentro de 15 minutos");
        }
        
        // Si no está bloqueada, buscara al usuario
        Usuario usuario = usuarioRepository.findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("Este correo electrónico no esta registrado"));
        
        // Se eliminará el bloqueo del Usuario
        return new User(usuario.getCorreo(), usuario.getContrasena(), new ArrayList<>());
    }
    
    
}
