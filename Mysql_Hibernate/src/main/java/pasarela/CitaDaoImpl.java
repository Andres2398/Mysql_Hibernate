package pasarela;

import entidades.Cita;
import entidades.CitaDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public class CitaDaoImpl extends GenericDaoImpl<Cita, Long> implements CitaDao {

    public CitaDaoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Cita buscarPorID(Long id) {
        return em.find(Cita.class, id);
    }

    @Override
    public List<Cita> buscarPorPacienteID(Long pacienteId) {
        TypedQuery<Cita> query = em.createQuery(
                "SELECT c FROM Cita c WHERE c.paciente.idPaciente = :pid", Cita.class);
        query.setParameter("pid", pacienteId);
        return query.getResultList();
    }

    @Override
    public List<Cita> buscarPorDoctorID(Long doctorId) {
        TypedQuery<Cita> query = em.createQuery(
                "SELECT c FROM Cita c WHERE c.doctor.idDoctor = :did", Cita.class);
        query.setParameter("did", doctorId);
        return query.getResultList();
    }

    @Override
    public List<Cita> buscarPorFecha(Date fecha) {
        TypedQuery<Cita> query = em.createQuery(
                "SELECT c FROM Cita c WHERE c.fecha = :fecha", Cita.class);
        query.setParameter("fecha", fecha);
        return query.getResultList();
    }
}
