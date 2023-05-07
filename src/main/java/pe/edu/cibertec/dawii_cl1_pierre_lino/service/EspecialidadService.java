package pe.edu.cibertec.dawii_cl1_pierre_lino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dawii_cl1_pierre_lino.model.bd.Especialidad;
import pe.edu.cibertec.dawii_cl1_pierre_lino.repository.EspecialidadRepository;

import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> listarEspecialidad(){
        return especialidadRepository.findAll();
    }

    public void registrarEspecialidad(Especialidad especialidad){
        especialidadRepository.save(especialidad);
    }

    public void eliminarEspecialidad(Especialidad especialidad){
        especialidadRepository.deleteById(especialidad.getIdesp());

    }

}
