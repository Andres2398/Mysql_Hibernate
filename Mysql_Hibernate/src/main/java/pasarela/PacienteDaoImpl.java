package pasarela;

import entidades.Paciente;
import entidades.PacienteDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public class PacienteDaoImpl extends GenericDaoImpl<Paciente, Long> implements PacienteDao {

    public PacienteDaoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Paciente buscarPorID(Long id) {
        return em.find(Paciente.class, id);
    }

    @Override
    public List<Paciente> buscarPorNombre(String nombre) {
        TypedQuery<Paciente> query = em.createQuery(
                "SELECT p FROM Paciente p WHERE p.nombre = :nombre", Paciente.class);
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }

    @Override
    public List<Paciente> buscarPorFechaNacimiento(Date desde, Date hasta) {
        TypedQuery<Paciente> query = em.createQuery(
                "SELECT p FROM Paciente p WHERE p.fechaNacimiento BETWEEN :desde AND :hasta", Paciente.class);
        query.setParameter("desde", desde);
        query.setParameter("hasta", hasta);
        return query.getResultList();
    }

    @Override
    public List<Paciente> buscarPorDoctorID(Long doctorId) {
        TypedQuery<Paciente> query = em.createQuery(
                "SELECT p FROM Paciente p JOIN p.doctores d WHERE d.idDoctor = :docId", Paciente.class);
        query.setParameter("docId", doctorId);
        return query.getResultList();
    }
}
