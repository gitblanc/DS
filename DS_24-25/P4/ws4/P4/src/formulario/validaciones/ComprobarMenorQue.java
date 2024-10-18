package formulario.validaciones;

import formulario.Validacion;

public class ComprobarMenorQue implements Validacion {

	private int i;

	public ComprobarMenorQue(int i) {
		this.i = i;
	}

	@Override
	public boolean isValid(String texto) {
		return Integer.parseInt(texto) < i;
	}

}
