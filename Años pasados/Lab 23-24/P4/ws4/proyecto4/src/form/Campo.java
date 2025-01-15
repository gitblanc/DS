package form;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import validators.Validador;
import validators.ValidadorNumero;
import validators.ValidadorTexto;

public class Campo {

	public static final Validador TEXTO = new ValidadorTexto();
	public static final Validador NUMERO = new ValidadorNumero();

	private Validador validador;
	private String etiqueta;
	private String texto;

	public Campo(String label, Validador val) {
		this.etiqueta = label;
		this.validador = val;
	}

	public void pideDato() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.print(etiqueta);
				String input = consola.readLine();

				if (this.validador.isValid(input)) {
					this.texto = input;
					return;
				}

			} catch (IOException ex) {
				System.out.println(ex);
			}
		}
	}

	public String getDato() {
		return this.texto;
	}
}
