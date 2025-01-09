package main;

import formulario.Campo;
import formulario.Formulario;
import formulario.validaciones.ValidadorCompuestoAnd;
import formulario.validaciones.ValidadorCompuestoOr;
import formulario.validaciones.ValidadorLongitud;
import formulario.validaciones.ValidadorMayorQue;
import formulario.validaciones.ValidadorMenorQue;
import formulario.validaciones.ValidadorNumero;
import formulario.validaciones.ValidadorTexto;
import formulario.validaciones.ValidadorValoresPredefinidos;

/**
 * IMPORTANTE: El código entregado para esta práctica es el mínimo necesario
 * para entender el ejercicio y NUNCA debería ser tomado como un ejemplo del uso
 * adecuado de excepciones, asertos y tests. Todos los elementos anteriores, que
 * deberían hacerse en un programa real, se han omitido a propósito para
 * simplificar el planteamiento del ejercicio.
 */

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new Campo("Nombre", new ValidadorTexto()));
		formulario.addCampo(new Campo("Apellido", new ValidadorTexto()));
		formulario.addCampo(new Campo("Teléfono", new ValidadorNumero()));
		formulario.addCampo(new Campo("Ciudad", new ValidadorValoresPredefinidos("Santander", "Oviedo", "Cádiz")));
		
		formulario.addCampo(new Campo("Código de producto", new ValidadorLongitud(4)));

		formulario.addCampo(
				new Campo("Código postal", new ValidadorCompuestoAnd(new ValidadorNumero(), new ValidadorLongitud(5))));

		formulario.addCampo(new Campo("Sueldo", new ValidadorCompuestoAnd(new ValidadorNumero(),
				new ValidadorMayorQue(800), new ValidadorMenorQue(1200))));

		formulario.addCampo(new Campo("Ubicación",
				new ValidadorCompuestoOr(new ValidadorValoresPredefinidos("Santander", "Oviedo", "Cádiz"),
						new ValidadorCompuestoAnd(new ValidadorNumero(), new ValidadorLongitud(5)))));

		formulario.addCampo(new Campo("Código de promoción",
				new ValidadorCompuestoOr(new ValidadorTexto(), new ValidadorNumero())));

		formulario.pideDatos();
	}
}
