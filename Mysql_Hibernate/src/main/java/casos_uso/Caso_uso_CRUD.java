package casos_uso;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.HibernateUtil;
import entidades.Paciente;

import pasarela.PacienteDaoImpl;

public class Caso_uso_CRUD {
	private PacienteDaoImpl pasarelaPaciente;

	public Caso_uso_CRUD(PacienteDaoImpl pasarelaPaciente) {
		this.pasarelaPaciente = pasarelaPaciente;

	}

	public void añadirPaciente(Paciente p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		pasarelaPaciente.crear(p);
		tx = session.beginTransaction();
		tx.commit();

	}
	
	
	public void actualizarPaciente(Paciente p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		pasarelaPaciente.actualizar(p);
		tx = session.beginTransaction();
		tx.commit();
	}
	
	public void eliminarPaciente(Paciente p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		pasarelaPaciente.eliminar(p);
		tx = session.beginTransaction();
		tx.commit();
	}
	
	public Paciente buscarPorID(Long id) {
		Paciente p=pasarelaPaciente.buscarPorID(id);
		return p;
		
		
	}
	
	public List<Paciente> buscarPorNombre(String nombre){
		List<Paciente> pacientes=pasarelaPaciente.buscarPorNombre(nombre);
		return pacientes;
	}
	
	public 
}
