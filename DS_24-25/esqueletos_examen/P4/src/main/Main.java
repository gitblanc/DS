package main;

import formulario.*;

/**
 * IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones, asertos
 * y tests. Todos los elementos anteriores, que deberían hacerse en un programa real, se han omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

public class Main {

    public static void main(String[] args) {
        Formulario formulario = new Formulario();

        formulario.addCampo(new CampoTexto("Nombre"));
        formulario.addCampo(new CampoTexto("Apellido"));
        formulario.addCampo(new CampoNumero("Teléfono"));
        formulario.addCampo(new CampoValoresPredefinidos("Ciudad", "Santander", "Oviedo", "Cádiz"));

        formulario.pideDatos();
    }
}
