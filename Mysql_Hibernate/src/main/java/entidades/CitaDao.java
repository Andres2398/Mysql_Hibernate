package entidades;

import java.sql.Date;
import java.util.List;

public interface CitaDao extends GenericDao<Cita, Long> {

    Cita buscarPorID(Long id);

    // Buscar citas por paciente
    List<Cita> buscarPorPacienteID(Long pacienteId);

    // Buscar citas por doctor
    List<Cita> buscarPorDoctorID(Long doctorId);

    // Buscar citas por fecha
    List<Cita> buscarPorFecha(Date fecha);
}
