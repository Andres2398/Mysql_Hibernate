package presentacion;

import casos_uso.CasoUsoRegistrar;

public class Presentador {
	
	private final CasoUsoRegistrar casoUno;
	

	private final Vista vista = new Vista(this);

	// Inyección de dependencias
	public Presentador(CasoUsoRegistrar c) {
		this.casoUno = c;
		

		this.aTrabajar();

	}

	private void aTrabajar() {
		vista.login();
		
	}

}
