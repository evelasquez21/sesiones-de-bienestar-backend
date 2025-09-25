/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.serviceImplements;

import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.entity.RegistroAuditoria;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.repository.RegistroAuditoriaRepository;
import gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar.services.RegistroAuditoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class RegistroAuditoriaServiceImpl implements RegistroAuditoriaService{
    @Autowired
    private RegistroAuditoriaRepository regAudiRepo;

    @Override
    public List<RegistroAuditoria> obtenerTodoRegAudi() {
        return regAudiRepo.findAll();
    }

    @Override
    public Optional<RegistroAuditoria> obtenerRegAudiPorId(Long id) {
        return regAudiRepo.findById(id);
    }

    @Override
    public RegistroAuditoria guardarRegAudi(RegistroAuditoria regAudi) {
        return regAudiRepo.save(regAudi);
    }

    @Override
    public void eliminarServicio(Long id) {
        regAudiRepo.deleteById(id);
    }

   
    
}
