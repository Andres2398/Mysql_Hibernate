package presentacion;

import java.sql.Date;

import casos_uso.CasoUsoRegistrar;
import entidades.Paciente;

public class Presentador {
	
	private final CasoUsoRegistrar casoUno;
	Paciente paciente;
	

	private final Vista vista = new Vista(this);

	// Inyección de dependencias
	public Presentador(CasoUsoRegistrar c) {
		this.casoUno = c;
		this.aTrabajar();

	}

	private void aTrabajar() {
		vista.login();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vista.interfazUsuario(paciente);
		
	}

	public boolean confirmarCreacionUsuario(String usuario, String contrasena, String nombre, Date fechaNacimiento) {
		Paciente p=casoUno.ejecutar(nombre, usuario, nombre, null, fechaNacimiento);
		paciente = p;
		return p==null;
		
		
	}

	public void accederInterfazClinica(String usuario, String contrasena) {
		casoUno.
		
	}

}
