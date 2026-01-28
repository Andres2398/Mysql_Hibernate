package app;

import casos_uso.CasoUsoRegistrar;
import entidades.Paciente;
import jakarta.persistence.EntityManager;
import pasarela.CrearBaseDatos;
import pasarela.InicializarBaseDatos;
import pasarela.PacienteDaoImpl;
import presentacion.Presentador;

/**
 * 
 * PRUEBA JPA CON HIBERNATE
 * 
 * 
 */
public class App {

	public static void main(String[] args) {

		System.out.println("=========================================");
		System.out.println("    INICIANDO SISTEMA DE GESTIÓN         ");
		System.out.println("=========================================\n");

		CrearBaseDatos.creaBaseDatos();
		
		
		InicializarBaseDatos.inicializarDatos();

		EntityManager em = HibernateUtil.getSessionFactory().openSession();

		PacienteDaoImpl pasarelaPaciente = new PacienteDaoImpl(em);

		CasoUsoRegistrar caso1 = new CasoUsoRegistrar(pasarelaPaciente);
		
		new Presentador(caso1);

	}
}