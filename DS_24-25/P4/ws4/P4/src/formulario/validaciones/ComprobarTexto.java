package formulario.validaciones;

import formulario.Validacion;

public class ComprobarTexto implements Validacion {

	@Override
	public boolean isValid(String texto) {
		for (char ch : texto.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}
}
