package pasarela;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.HibernateUtil;
import entidades.Doctor;

public class InicializarBaseDatos {

    public static void inicializarDatos() {

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Long count = session
                    .createQuery("SELECT COUNT(d) FROM Doctor d", Long.class)
                    .uniqueResult();

            if (count != null && count > 0) {
               
                tx.commit();
                return;
            }

            session.persist(new Doctor("Juan Pérez", "Cardiología"));
            session.persist(new Doctor("Ana Gómez", "Pediatría"));
            session.persist(new Doctor("Luis Martín", "Traumatología"));
            session.persist(new Doctor("Laura Ruiz", "Dermatología"));
            session.persist(new Doctor("Carlos Santos", "Neurología"));

            tx.commit();
            System.out.println("✅ Doctores iniciales insertados");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        } finally {
            if (session != null) session.close();
        }
    }
}
