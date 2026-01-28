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
		vista.interfazUsuario(paciente);
		
	}

	public void confirmarCreacionUsuario(String usuario, String contrasena, String nombre, Date fechaNacimiento) {
		Paciente p=casoUno.ejecutar(nombre, usuario, nombre, null, fechaNacimiento);
		paciente = p;
		
	}

	public void accederInterfazClinica(String usuario, String contrasena) {
		casoUno.
		
	}

}
