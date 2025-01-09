/**
 * 
 */
package formulario.validaciones;

import formulario.Validador;

/**
 * 
 */
public class ValidadorLongitud implements Validador {

	private int valor;

	public ValidadorLongitud(int i) {
		this.valor = i;
	}

	@Override
	public boolean isValid(String texto) {
		return texto.length() == this.valor;
	}

}
