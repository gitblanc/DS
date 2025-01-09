/**
 * 
 */
package formulario.validaciones;

import formulario.Validador;

/**
 * 
 */
public class ValidadorMenorQue implements Validador {

	private int valor;

	public ValidadorMenorQue(int i) {
		this.valor = i;
	}

	@Override
	public boolean isValid(String texto) {
		return Integer.parseInt(texto) < this.valor;
	}

}
