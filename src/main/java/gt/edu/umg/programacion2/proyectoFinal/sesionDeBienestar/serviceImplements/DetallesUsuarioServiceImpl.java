/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.UsuarioRepository;
import java.time.LocalDateTime;
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
        Usuario usuario = usuarioRepository.findByCorreo(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        
        if (usuario.isCuentaBloqueada()){
            if (usuario.getTiempoDeDesbloqueo() != null && usuario.getTiempoDeDesbloqueo().plusMinutes(intentosSesion.duracionMinutos).isAfter(LocalDateTime.now())) {
                throw new LockedException("La cuenta ha sido bloqueda. Intente nuevamente dentro de 5 minutos");
            }
        } else {
            intentosSesion.sesionExitosa(username);
        }
        
        return new User(usuario.getCorreo(), usuario.getContrasena(), new ArrayList<>());
    }
    
    
}
