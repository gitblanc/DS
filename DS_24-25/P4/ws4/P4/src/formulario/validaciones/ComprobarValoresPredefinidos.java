package formulario.validaciones;

import formulario.Validacion;

public class ComprobarValoresPredefinidos implements Validacion {

	private String[] valores;

	public ComprobarValoresPredefinidos(String... valores) {
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
