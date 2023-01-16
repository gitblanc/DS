/**
 * 
 */
package form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import form.validator.NumberValidator;
import form.validator.TextValidator;
import form.validator.Validator;

/**
 * @author omenp
 *
 */
public class Campo {
	public static final Validator TEXT = new TextValidator();
	public static final Validator NUMBER = new NumberValidator();

	private String texto;
	private String etiqueta;
	private Validator validator;

	public Campo(String label, Validator validator) {
		if (label == null || label.trim().isEmpty())
			throw new IllegalArgumentException("Se necesita la etiqueta para este campo de formulario");
		if (validator == null)
			throw new IllegalArgumentException("¿Qué tipo de campo es? Se necesita un validador no nulo");

		this.etiqueta = label;
		this.validator = validator;
	}

	public void pideDato() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print(etiqueta + ": ");
				String value = input.readLine();
				if (validator.isValid(value)) {
					this.texto = value;
					return;
				}
				System.out.println("El valor introducido para \"" + etiqueta + "\" no es válido: " + value + " ("
						+ validator.getMessage() + ")");
			} catch (IOException e) {
				System.out.println("No se pudo leer el valor del campo: " + e);
			}
			System.out.println("Inténtelo de nuevo...");
		}
	}

	public String getString() {
		return texto;
	}

}
