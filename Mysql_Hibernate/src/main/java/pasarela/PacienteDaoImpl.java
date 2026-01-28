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
	public Paciente buscarPorUsuario(String usuario) {
		return em.createQuery("SELECT p FROM Paciente p WHERE p.usuario = :u", Paciente.class)
				.setParameter("u", usuario).getResultStream().findFirst().orElse(null);
	}

	@Override
	public boolean existeUsuario(String usuario) {
		Long count = em.createQuery("SELECT COUNT(p) FROM Paciente p WHERE p.usuario = :u", Long.class)
				.setParameter("u", usuario).getSingleResult();

		return count > 0;
	}

	@Override
	public Paciente login(String usuario, String password) {
		return em.createQuery("SELECT p FROM Paciente p WHERE p.usuario = :u AND p.password = :p", Paciente.class)
				.setParameter("u", usuario).setParameter("p", password).getResultStream().findFirst().orElse(null);
	}

}
