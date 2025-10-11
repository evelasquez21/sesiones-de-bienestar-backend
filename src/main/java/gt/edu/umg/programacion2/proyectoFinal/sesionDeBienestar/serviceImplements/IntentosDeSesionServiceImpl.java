/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.UsuarioRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class IntentosDeSesionServiceImpl {
    public static final int maximosIntentos = 3;
    public static final long duracionMinutos = 5;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public void sesionExitosa(String correo){
        Usuario usuario = usuarioRepository.findByCorreo(correo).orElse(null);
        if (usuario != null && usuario.getIntentosFallidos() > 0){
            usuario.setIntentosFallidos(0);
            usuario.setTiempoDeDesbloqueo(null);
            usuario.setCuentaBloqueada(false);
            usuarioRepository.save(usuario);
        }
    }
    
    public void SesionFallida(String correo){
        Usuario usuario = usuarioRepository.findByCorreo(correo).orElse(null);
        if (usuario != null){
            usuario.setIntentosFallidos(usuario.getIntentosFallidos() + 1);
            if (usuario.getIntentosFallidos() >= maximosIntentos) {
                usuario.setCuentaBloqueada(true);
                usuario.setTiempoDeDesbloqueo(LocalDateTime.now());
            }
            usuarioRepository.save(usuario);
        }
    }
}
