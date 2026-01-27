package pasarela;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import app.HibernateUtil;
import entidades.Cita;
import entidades.Doctor;
import entidades.HistorialMedico;
import entidades.Paciente;

import java.sql.Date;
import java.util.Set;

public class InicializarBaseDatos {

	public static void inicializarDatos() {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			// Comprueba si ya hay doctores
			Query<Long> query = session.createQuery("SELECT COUNT(d) FROM Doctor d", Long.class);
			Long count = query.uniqueResult();

			if (count != null && count > 0) {
				System.out.println("⚠️ Datos ya existen. No se insertarán de nuevo.");
				return;
			}

			// ======================
			// Doctores
			// ======================
			Doctor doctor1 = new Doctor("Juan Pérez", "Cardiología");
			Doctor doctor2 = new Doctor("Ana Gómez", "Pediatría");

			session.persist(doctor1);
			session.persist(doctor2);

			// ======================
			// Pacientes
			// ======================
			Paciente paciente1 = new Paciente("Carlos López", Date.valueOf("1990-05-12"));

			Paciente paciente2 = new Paciente("María Torres", Date.valueOf("1985-09-23"));

			// Historial médico (1–1)
			HistorialMedico historial1 = new HistorialMedico("O+", "Ninguna");
			historial1.setPaciente(paciente1);
			paciente1.setHistorialMedico(historial1);

			HistorialMedico historial2 = new HistorialMedico("A-", "Penicilina");
			historial2.setPaciente(paciente2);
			paciente2.setHistorialMedico(historial2);

			// Relación N–M
			paciente1.setDoctores(Set.of(doctor1, doctor2));
			paciente2.setDoctores(Set.of(doctor1));

			session.persist(paciente1);
			session.persist(paciente2);

			// ======================
			// Citas
			// ======================
			Cita cita1 = new Cita(Date.valueOf("2026-01-27"), doctor1, paciente1);
			Cita cita2 = new Cita(Date.valueOf("2026-01-28"), doctor2, paciente1);
			Cita cita3 = new Cita(Date.valueOf("2026-01-29"), doctor1, paciente2);

			session.persist(cita1);
			session.persist(cita2);
			session.persist(cita3);

			tx.commit();

			System.out.println("✅ Datos iniciales insertados correctamente");

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		
		} finally {
			if (session != null)
				session.close();
		}
	}
}
