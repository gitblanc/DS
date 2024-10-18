/**
 * 
 */
package formulario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */
public class Campo {
	private String etiqueta;
	private String texto;
	private Validacion validacion;

	public Campo(String etiqueta, Validacion validacion) {
		this.etiqueta = etiqueta;
		this.validacion = validacion;
	}

	public String getDato() {
		return texto;
	}

	public void pideDato() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		do {
			try {
				System.out.print(etiqueta + ": ");
				texto = consola.readLine();
			} catch (IOException ex) {
				System.out.println(ex);
			}

		} while (!validacion.isValid(texto));
	}
}
