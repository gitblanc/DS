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
        input ancho;
        input alto;
        area = alto * ancho;
        print area / 2;
        */

        // input ancho;
        var inputAncho = new Input(new Variable("ancho"));

        // input alto;
        var inputAlto = new Input(new Variable("alto"));

        // area = alto * ancho / 2;
        var area = new Assignment(
                new Variable("area"),
                new Arithmetic(new Variable("alto"), "*", new Variable("ancho")));

        // print area + 10;
        var print = new Print(new Arithmetic(new Variable("area"), "/", new IntLiteral(2)));

        // Crear el programa
        Program program = new Program(List.of(inputAncho, inputAlto, area, print));

        // Formatear el programa
        var formatter = new format.Formatter();
        program.accept(formatter, null);
        
        // Ejecutar el programa
        var interpreter = new format.Interpreter();
        program.accept(interpreter, null);

    }
}
