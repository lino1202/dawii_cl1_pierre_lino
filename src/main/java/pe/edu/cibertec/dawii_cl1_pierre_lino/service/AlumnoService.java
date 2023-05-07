package pe.edu.cibertec.dawii_cl1_pierre_lino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dawii_cl1_pierre_lino.model.bd.Alumno;
import pe.edu.cibertec.dawii_cl1_pierre_lino.repository.AlumnoRepository;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos(){

        return alumnoRepository.findAll();
    }

    public void registrarAlumno(Alumno alumno){

        alumnoRepository.save(alumno);
    }

    public void eliminarAlumno(String idalumno){
        alumnoRepository.deleteById(idalumno);

    }
}
