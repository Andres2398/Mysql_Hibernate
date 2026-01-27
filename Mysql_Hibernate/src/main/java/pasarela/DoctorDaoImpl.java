package pasarela;

import entidades.Doctor;
import entidades.DoctorDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class DoctorDaoImpl extends GenericDaoImpl<Doctor, Long> implements DoctorDao {

    public DoctorDaoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Doctor buscarPorID(Long id) {
        return em.find(Doctor.class, id);
    }

    @Override
    public List<Doctor> buscarPorNombre(String nombre) {
        TypedQuery<Doctor> query = em.createQuery(
                "SELECT d FROM Doctor d WHERE d.nombre = :nombre", Doctor.class);
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }

    @Override
    public List<Doctor> buscarPorEspecialidad(String especialidad) {
        TypedQuery<Doctor> query = em.createQuery(
                "SELECT d FROM Doctor d WHERE d.especialidad = :esp", Doctor.class);
        query.setParameter("esp", especialidad);
        return query.getResultList();
    }
}
