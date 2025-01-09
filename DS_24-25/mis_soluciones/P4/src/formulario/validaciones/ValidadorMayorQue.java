/**
 * 
 */
package formulario.validaciones;

import formulario.Validador;

/**
 * 
 */
public class ValidadorMayorQue implements Validador {

	private int valor;

	public ValidadorMayorQue(int i) {
		this.valor = i;
	}

	@Override
	public boolean isValid(String texto) {
		return Integer.parseInt(texto) > this.valor;
	}

}
