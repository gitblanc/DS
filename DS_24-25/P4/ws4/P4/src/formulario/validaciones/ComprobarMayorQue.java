package formulario.validaciones;

import formulario.Validacion;

public class ComprobarMayorQue implements Validacion {

	private int i;

	public ComprobarMayorQue(int i) {
		this.i = i;
	}

	@Override
	public boolean isValid(String texto) {
		return Integer.parseInt(texto) > i;
	}

}
