package formulario.validaciones;

import formulario.Validador;

public class ValidadorNumero implements Validador {

	@Override
	public boolean isValid(String texto) {
		// Comprobar si el texto introducido está formado por dígitos
		for (char ch : texto.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
}
