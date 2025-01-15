import java.util.*;

public class Formulario {
	public void addCampo(Campo campo) {
		campos.add(campo);
	}

	public void PideDatos() {
		for (Campo campo : campos) {
			campo.pideDato();
			System.out.println(campo.getString());//cambiarlo
		}
	}

	private List<Campo> campos = new ArrayList<Campo>();
}
