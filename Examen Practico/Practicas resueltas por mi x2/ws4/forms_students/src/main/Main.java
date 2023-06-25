package main;

import form.*;
import form.validation.*;

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new Campo("Nombre", Campo.TEXT));
		formulario.addCampo(new Campo("Apellido", Campo.TEXT));
		formulario.addCampo(new Campo("Telefono", Campo.NUMBER));
		Validator cities = new PredefinedValidator("Santander", "Oviedo", "Cádiz");
		formulario.addCampo(new Campo("Ciudad", cities));

		// Ampliación
		formulario.addCampo(new Campo("Código de producto", new LengthValidator(4)));
		Validator postalCode = new AndValidator(Campo.NUMBER, new LengthValidator(5));
		formulario.addCampo(new Campo("Código postal", postalCode));
		formulario.addCampo(new Campo("Edad", new GreaterThanValidator(18)));
		formulario.addCampo(
				new Campo("Sueldo", new AndValidator(new GreaterThanValidator(800), new LessThanValidator(1200))));
		formulario.addCampo(new Campo("Ubicación", new OrValidator(cities, postalCode)));
		formulario.addCampo(new Campo("Código de promoción",
				new OrValidator(Campo.TEXT, new AndValidator(Campo.NUMBER, new LengthValidator(3)))));

		formulario.PideDatos();
	}
}
