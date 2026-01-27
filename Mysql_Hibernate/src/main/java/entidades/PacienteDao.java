package entidades;

import java.sql.Date;
import java.util.List;

public interface PacienteDao extends GenericDao<Paciente, Long> {

    Paciente buscarPorID(Long id);

    // Buscar por nombre
    List<Paciente> buscarPorNombre(String nombre);

    // Buscar pacientes por rango de fecha de nacimiento
    List<Paciente> buscarPorFechaNacimiento(Date desde, Date hasta);

    // Buscar pacientes de un doctor específico
    List<Paciente> buscarPorDoctorID(Long doctorId);
}
