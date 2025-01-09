package formulario.validaciones;

import formulario.Validador;

public class ValidadorValoresPredefinidos implements Validador {

	private String[] valores;

	public ValidadorValoresPredefinidos(String... valores) {
		this.valores = valores;
	}

	@Override
	public boolean isValid(String texto) {
		// Comprobar si el texto introducido está entre los valores permitidos
		for (String valor : valores) {
			if (texto.equalsIgnoreCase(valor)) {
				return true;
			}
		}
		return false;
	}
}
