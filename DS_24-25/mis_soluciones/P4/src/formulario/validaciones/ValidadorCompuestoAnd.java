/**
 * 
 */
package formulario.validaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import formulario.Validador;

/**
 * 
 */
public class ValidadorCompuestoAnd implements Validador {

	private List<Validador> validadores = new ArrayList<Validador>();

	public ValidadorCompuestoAnd(Validador... validadores) {
		this.validadores = Arrays.asList(validadores);
	}

	@Override
	public boolean isValid(String texto) {
		for (Validador v : validadores) {
			if (!v.isValid(texto))
				return false;
		}
		return true;
	}

}
