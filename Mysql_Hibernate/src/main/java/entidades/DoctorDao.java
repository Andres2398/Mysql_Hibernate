package entidades;

import java.util.List;

public interface DoctorDao extends GenericDao<Doctor, Long> {

    // Buscar un doctor por ID (override si quieres tipos específicos)
    Doctor buscarPorID(Long id);

    // Buscar doctor por nombre
    List<Doctor> buscarPorNombre(String nombre);

    // Buscar todos los doctores de una especialidad
    List<Doctor> buscarPorEspecialidad(String especialidad);
}
