package pe.edu.cibertec.dawii_cl1_pierre_lino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.dawii_cl1_pierre_lino.model.bd.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {
}
