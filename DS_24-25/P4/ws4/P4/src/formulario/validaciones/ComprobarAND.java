package formulario.validaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import formulario.Validacion;

public class ComprobarAND implements Validacion {

	private List<Validacion> validaciones = new ArrayList<>();

	public ComprobarAND(Validacion... validaciones) {
		this.validaciones = Arrays.asList(validaciones);
	}

	@Override
	public boolean isValid(String texto) {
		for (Validacion v : this.validaciones) {
			if (!v.isValid(texto))
				return false;
		}
		return true;
	}

}
