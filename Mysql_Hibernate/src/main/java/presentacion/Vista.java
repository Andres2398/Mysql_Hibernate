package presentacion;

import java.sql.Date;

import presentacion.interfaz.ventana.InterfazLogin;

public class Vista {
	Presentador pr;
	
	public Vista(Presentador presentador) {
		pr=presentador;
	}

	public void login() {
		 InterfazLogin inLo = new InterfazLogin(this);
		 inLo.setVisible(true);
		
	}

	public void comprobarUsuario(String usuario, String contrasena, String nombre, Date fechaNacimiento) {
		pr.confirmarCreacionUsuario(usuario,contrasena,nombre,fechaNacimiento);
		
	}

	public void acceder(String usuario, String contrasena) {
		pr.accederInterfazClinica(usuario, contrasena);
		
	}
	
	

}
