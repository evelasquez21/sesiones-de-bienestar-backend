/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.RegistroPeticionDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.dtos.UsuarioDTO;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.UsuarioRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.UsuarioService;
import java.math.BigInteger;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduar
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    
    public Usuario registrarUsuario(RegistroPeticionDTO registroPeticion){
        if (usuarioRepository.findByCorreo(registroPeticion.getCorreo()).isPresent()){
            throw new RuntimeException("El correco electrónico ya está en uso");
        } else if(usuarioRepository.findById(registroPeticion.getDpi()).isPresent()){
            throw new RuntimeException("El número de DPI ya está registrado");
        }
        
        
        Usuario nuevoUsuario = new Usuario();
        
        nuevoUsuario.setDpi(registroPeticion.getDpi());
        nuevoUsuario.setNombreCompleto(registroPeticion.getNombreCompleto());
        nuevoUsuario.setDireccion(registroPeticion.getDireccion());
        nuevoUsuario.setFechaNacimiento(registroPeticion.getFechaNacimiento());
        nuevoUsuario.setTelefono(registroPeticion.getTelefono());
        nuevoUsuario.setCorreo(registroPeticion.getCorreo());
        
        nuevoUsuario.setContrasena(passwordEncoder.encode(registroPeticion.getContrasena()));
        nuevoUsuario.setCuentaBloqueada(false);
        
        return usuarioRepository.save(nuevoUsuario);
    }
    
    @Transactional
    public UsuarioDTO obtenerUsuarioAcutal(Usuario usuario){
        Usuario usuarioActual = usuarioRepository.findById(usuario.getDpi()).orElse(null);
        return convertirADto(usuarioActual);
    }
    
    // Convertir entidad a DTO
    private UsuarioDTO convertirADto(Usuario usuario){
        // Creación de DTO principal
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setDpi(usuario.getDpi());
        usuarioDTO.setNombreCompleto(usuario.getNombreCompleto());
        usuarioDTO.setDireccion(usuario.getDireccion());
        usuarioDTO.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioDTO.setTelefono(usuario.getTelefono());
        usuarioDTO.setCorreo(usuario.getCorreo());
        
        return usuarioDTO;
    }

    @Override
    public List<Usuario> obtenerTodoLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorDpi(BigInteger dpi) {
        return usuarioRepository.findById(dpi);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(BigInteger dpi) {
        usuarioRepository.deleteById(dpi);
    }

    
    
}
