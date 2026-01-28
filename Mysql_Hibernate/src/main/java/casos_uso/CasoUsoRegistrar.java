package casos_uso;

import java.sql.Date;

import entidades.Paciente;
import entidades.PacienteDao;

public class CasoUsoRegistrar {

	private final PacienteDao pacienteDao;

	public CasoUsoRegistrar(PacienteDao pacienteDao) {
		this.pacienteDao = pacienteDao;
	}

	public Paciente ejecutar(String nombre, String usuario, String password, Double cuota, Date fechaNacimiento) {

		if (pacienteDao.existeUsuario(usuario)) {
			throw new RuntimeException("Usuario ya existe");
		}

		Paciente paciente = new Paciente(nombre, usuario, password, cuota, fechaNacimiento);

		pacienteDao.crear(paciente);
		return paciente;
	}
}
