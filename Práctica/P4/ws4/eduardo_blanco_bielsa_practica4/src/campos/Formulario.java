package campos;

import java.util.*;

public class Formulario {
	private List<Campo> campos = new ArrayList<Campo>();

	public void addCampo(Campo campo) {
		campos.add(campo);
	}

	public void PideDatos() {
		for (Campo campo : campos) {
			campo.pideDato();
			System.out.println(campo.getValor());
		}
	}

	public void generarCampos() {
		addCampo(new CampoTexto("Nombre"));
		addCampo(new CampoTexto("Apellido"));
		addCampo(new CampoNumero("Telefono"));
		addCampo(new CampoPredefinido("Ciudad", "Santander", "Oviedo", "Cadiz"));
	}

	public void pedirDatos() {
		PideDatos();
	}
}
