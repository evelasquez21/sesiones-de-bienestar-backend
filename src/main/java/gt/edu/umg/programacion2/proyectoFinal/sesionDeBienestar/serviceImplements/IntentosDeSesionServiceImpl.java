/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.UsuarioRepository;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduar
 */
@Service
public class IntentosDeSesionServiceImpl {
    public static final int maximosIntentos = 3;
    private final LoadingCache<String, Integer> intentosCache;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    // Constructor de clase
    public IntentosDeSesionServiceImpl() {
        super();
        // Inicialización del cache
        intentosCache = CacheBuilder.newBuilder()
            // Determinación de 15 minutos después del último intento de sesión
            .expireAfterWrite(15, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Integer>() {
                public Integer load(String key){
                    return 0;
                }
            });
    }
    
    public void sesionExitosa(String key){
        // Línea para eliminar al usuario del cache
        Usuario usuario = usuarioRepository.findByCorreo(key).orElse(null);
        
        if (usuario != null){
            intentosCache.invalidate(key);
            usuario.setIntentosFallidos(0);
            usuario.setCuentaBloqueada(false);
            usuario.setTiempoDeDesbloqueo(null);
            usuarioRepository.save(usuario);
        }
        
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void SesionFallida(String key){
        Usuario usuario = usuarioRepository.findByCorreo(key).orElse(null);
        int intentos = 0;
        if (usuario != null) {
            intentos = usuario.getIntentosFallidos();
            intentos++;
            intentosCache.put(key, intentos);
            usuario.setIntentosFallidos(intentos);
            
            if (sesionBloqueada(key)){
                usuario.setCuentaBloqueada(true);
                usuario.setTiempoDeDesbloqueo(LocalDateTime.now());
            }
            
            usuarioRepository.save(usuario);
        }
        
    }
    
    public boolean sesionBloqueada(String key){
        try {
            // Revisión del último número de intentos
            return intentosCache.get(key) >= maximosIntentos;
        } catch (ExecutionException e) {
            return false;
        }
    }
}
