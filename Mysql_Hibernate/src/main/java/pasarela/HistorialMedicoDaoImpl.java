package pasarela;

import entidades.HistorialMedico;
import entidades.HistorialMedicoDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class HistorialMedicoDaoImpl extends GenericDaoImpl<HistorialMedico, Long> implements HistorialMedicoDao {

    public HistorialMedicoDaoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public HistorialMedico buscarPorID(Long id) {
        return em.find(HistorialMedico.class, id);
    }

    @Override
    public List<HistorialMedico> buscarPorTipoSangre(String tipoSangre) {
        TypedQuery<HistorialMedico> query = em.createQuery(
                "SELECT h FROM HistorialMedico h WHERE h.tipoSangre = :tipo", HistorialMedico.class);
        query.setParameter("tipo", tipoSangre);
        return query.getResultList();
    }

    @Override
    public List<HistorialMedico> buscarPorAlergia(String alergia) {
        TypedQuery<HistorialMedico> query = em.createQuery(
                "SELECT h FROM HistorialMedico h WHERE h.alergias LIKE :alergia", HistorialMedico.class);
        query.setParameter("alergia", "%" + alergia + "%");
        return query.getResultList();
    }
}
