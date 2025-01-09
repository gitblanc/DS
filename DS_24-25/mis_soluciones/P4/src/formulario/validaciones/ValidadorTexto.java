package formulario.validaciones;

import formulario.Validador;

public class ValidadorTexto implements Validador {

	@Override
	public boolean isValid(String texto) {
		// Comprobar si el texto introducido está formado por letras
		for (char ch : texto.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}
}
