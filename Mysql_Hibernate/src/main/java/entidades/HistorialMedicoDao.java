package entidades;

import java.util.List;

public interface HistorialMedicoDao extends GenericDao<HistorialMedico, Long> {

    HistorialMedico buscarPorID(Long id);

    // Buscar por tipo de sangre
    List<HistorialMedico> buscarPorTipoSangre(String tipoSangre);

    // Buscar pacientes con alergias específicas
    List<HistorialMedico> buscarPorAlergia(String alergia);
}
