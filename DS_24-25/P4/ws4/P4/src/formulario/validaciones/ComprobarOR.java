package formulario.validaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import formulario.Validacion;

public class ComprobarOR implements Validacion {

	private List<Validacion> validaciones = new ArrayList<>();

	public ComprobarOR(Validacion... vs) {
		this.validaciones = Arrays.asList(vs);
	}

	@Override
	public boolean isValid(String texto) {
		for (Validacion v : validaciones) {
			if (v.isValid(texto))
				return true;
		}
		return false;
	}

}