/**
 * 
 */
package formulario.validaciones;

import formulario.Validacion;

/**
 * 
 */
public class ComprobarLongitud implements Validacion {
	private int longitud;

	public ComprobarLongitud(int i) {
		this.longitud = i;
	}

	@Override
	public boolean isValid(String texto) {
		return texto.length() == this.longitud;
	}

}
