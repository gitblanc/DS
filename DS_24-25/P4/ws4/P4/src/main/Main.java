package main;

import formulario.Campo;
import formulario.Formulario;
import formulario.validaciones.ComprobarAND;
import formulario.validaciones.ComprobarMayorQue;
import formulario.validaciones.ComprobarMenorQue;
import formulario.validaciones.ComprobarLongitud;
import formulario.validaciones.ComprobarNumero;
import formulario.validaciones.ComprobarOR;
import formulario.validaciones.ComprobarTexto;
import formulario.validaciones.ComprobarValoresPredefinidos;

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

		formulario.addCampo(new Campo("Nombre", new ComprobarTexto()));
		formulario.addCampo(new Campo("Apellido", new ComprobarTexto()));
		formulario.addCampo(new Campo("Teléfono", new ComprobarNumero()));
		formulario.addCampo(new Campo("Ciudad", new ComprobarValoresPredefinidos("Santander", "Oviedo", "Cádiz")));
		formulario.addCampo(new Campo("Código de Producto", new ComprobarLongitud(4)));
		formulario.addCampo(
				new Campo("Código Postal", new ComprobarAND(new ComprobarNumero(), new ComprobarLongitud(5))));
		formulario.addCampo(new Campo("Edad", new ComprobarAND(new ComprobarNumero(), new ComprobarMayorQue(18))));
		formulario.addCampo(new Campo("Sueldo",
				new ComprobarAND(new ComprobarNumero(), new ComprobarMayorQue(800), new ComprobarMenorQue(1200))));
		formulario.addCampo(
				new Campo("Ubicacion", new ComprobarOR(new ComprobarValoresPredefinidos("Santander", "Oviedo", "Cádiz"),
						new ComprobarAND(new ComprobarNumero(), new ComprobarLongitud(5)))));
		formulario.addCampo(new Campo("Código de promoción", new ComprobarOR(new ComprobarTexto(),
				new ComprobarAND(new ComprobarNumero(), new ComprobarLongitud(3)))));

		formulario.pideDatos();
	}
}
