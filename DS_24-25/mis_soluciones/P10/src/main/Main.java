/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.util.List;

import nodes.*;

public class Main {

    public static void main(String[] args) {

        /*
         * input alto;
         * input ancho;
         * print alto * ancho;
         */

        // input alto;
        var inputAlto = new Input(new Variable("alto"));

        // input ancho;
        var inputAncho = new Input(new Variable("ancho"));

        // print alto * ancho;
        var print = new Print(new Arithmetic(new Variable("alto"), "*", new Variable("ancho")));

        // Crear el programa
        Program program = new Program(List.of(inputAlto, inputAncho, print));

        // Formatear el programa
        var formatter = new format.Formatter();
        program.selectMethod(formatter);
    }
}
