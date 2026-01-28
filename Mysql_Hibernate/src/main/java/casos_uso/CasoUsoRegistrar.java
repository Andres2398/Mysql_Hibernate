package casos_uso;

import java.sql.Date;

import entidades.Paciente;
import entidades.PacienteDao;

public class CasoUsoRegistrar {

	private final PacienteDao pacienteDao;

	public CasoUsoRegistrar(PacienteDao pacienteDao) {
		this.pacienteDao = pacienteDao;
	}

	public Paciente ejecutar(String nombre, String usuario, String password, Date fechaNacimiento, Date fechaNacimiento2) {

		if (pacienteDao.existeUsuario(usuario)) {
			throw new RuntimeException("Usuario ya existe");
		}

		Paciente paciente = new Paciente(nombre, usuario, password, fechaNacimiento);

		pacienteDao.crear(paciente);
		return paciente;
	}
	
	public Paciente accederSistema(String nombre, String contrasena) {
		pacienteDao.
		
		return null;
	}
}
