package form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import form.validation.NumberValidator;
import form.validation.TextValidator;
import form.validation.Validator;

public class Campo {
	public static final Validator TEXT = new TextValidator();
	public static final Validator NUMBER = new NumberValidator();
	private String label;
	private String value;
	private Validator validator;

	public Campo(String label, Validator validator) {
		if (label == null || label.isEmpty())
			throw new IllegalArgumentException("La label no puede ser null o estar vacía");
		this.label = label;
		this.validator = validator;
	}

	public void pideDato() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.print(label + ": ");
				String newValue = consola.readLine();

				if (validator.isValid(newValue)) {
					this.value = newValue;
					return;
				}
				System.out.println("El valor introducido no es válido");
			} catch (IOException ex) {
				System.out.println(ex);
			}
			System.out.println("Inténtalo de nuevo...");
		}
	}

	public String getString() {
		return value;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "Campo [label=" + label + ", value=" + value + ", validator=" + validator + "]";
	}

}