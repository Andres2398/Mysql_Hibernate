package presentacion;

import java.sql.Date;

import entidades.Paciente;
import presentacion.interfaz.ventana.InterfazLogin;
import presentacion.interfaz.ventana.InterfazPaciente;

public class Vista {
	Presentador pr;
	 InterfazLogin inLo;
	
	public Vista(Presentador presentador) {
		pr=presentador;
	}

	public void login() {
		 inLo = new InterfazLogin(this);
		 inLo.setVisible(true);
		
	}

	public void comprobarUsuario(String usuario, String contrasena, String nombre, Date fechaNacimiento) {
		boolean fallo=pr.confirmarCreacionUsuario(usuario,contrasena,nombre,fechaNacimiento);
		if(!fallo) {
			inLo.dispose();
			notifyAll();
		}
		else {
			System.out.println("Ventana fallo creacion");
		}
		
	}

	public void acceder(String usuario, String contrasena) {
		pr.accederInterfazClinica(usuario, contrasena);
		
	}

	public void interfazUsuario(Paciente paciente) {
		System.out.println("efasdfsafsadfsfasfasd");
		InterfazPaciente inPa = new InterfazPaciente(this);
		inPa.setVisible(true);
		
	}
	
	

}
