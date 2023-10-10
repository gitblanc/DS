package main;

import form.Campo;
import form.Formulario;
import validators.*;

/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario
 * para entender el ejercicio y NUNCA debería ser tomado como un ejemplo del uso
 * adecuado de excepciones, asertos y tests. Todo lo anterior, que debería
 * hacerse en un programa real, se ha omitido a propósito para simplificar el
 * planteamiento del ejercicio.
 */

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();
//VERSION ANTIGUA
//        formulario.addCampo(new CampoTexto("Nombre"));
//        formulario.addCampo(new CampoTexto("Apellido"));
//        formulario.addCampo(new CampoNumero("Teléfono"));
//        formulario.addCampo(new CampoPredefinido("Ciudad", "Santander", "Oviedo", "Cádiz"));

		// NUEVO CÓDIGO QUE FUNCIONA
		formulario.addCampo(new Campo("Nombre: ", Campo.TEXTO));
		formulario.addCampo(new Campo("Apellido: ", Campo.TEXTO));
		formulario.addCampo(new Campo("Teléfono: ", Campo.NUMERO));
		formulario.addCampo(new Campo("Ciudad: ", new ValidadorPredefinido("Santander", "Oviedo", "Cádiz")));

		// AÑADIMOS LAS EXTENSIONES QUE FUNCIONAN
		formulario.addCampo(new Campo("Código de producto: ", new ValidadorLongitud(4)));
		formulario.addCampo(new Campo("Código postal: ", new AndValidator(Campo.NUMERO, new ValidadorLongitud(5))));
		formulario.addCampo(new Campo("Edad: ", new AndValidator(Campo.NUMERO, new ValidadorEdad(18))));
		formulario.addCampo(new Campo("Sueldo: ", new AndValidator(Campo.NUMERO,
				new AndValidator(new ValidadorMayorQue(800), new ValidadorMenorQue(1200)))));
		formulario.addCampo(
				new Campo("Ubicación: ", new OrValidator(new ValidadorPredefinido("Santander", "Oviedo", "Cádiz"),
						new AndValidator(Campo.NUMERO, new ValidadorLongitud(5)))));
		formulario.addCampo(new Campo("Código de promoción: ",
				new OrValidator(Campo.TEXTO, new AndValidator(Campo.NUMERO, new ValidadorLongitud(3)))));
		formulario.pideDatos();
	}
}
