/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.Usuario;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author eduar
 */
public interface UsuarioService {
    List<Usuario> obtenerTodoLosUsuarios();
    Optional<Usuario> obtenerUsuarioPorDpi(BigInteger dpi);
    Usuario guardarUsuario(Usuario usuario);
    void eliminarUsuario(BigInteger dpi);
}
