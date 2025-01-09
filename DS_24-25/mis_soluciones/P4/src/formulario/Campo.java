package formulario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Campo {

	private String etiqueta;
	private String texto;
	private Validador validador;

	public Campo(String newEtiqueta, Validador v) {
		this.etiqueta = newEtiqueta;
		this.validador = v;
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

		} while (!validador.isValid(texto));
	}

	public String getDato() {
		return texto;
	}
}
