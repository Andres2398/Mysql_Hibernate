package entidades;

import java.sql.Date;
import java.util.List;

public interface PacienteDao extends GenericDao<Paciente, Long> {

	public Paciente buscarPorUsuario(String usuario);

    public boolean existeUsuario(String usuario);

    public Paciente login(String usuario, String password);
}
