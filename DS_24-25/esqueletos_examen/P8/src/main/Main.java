/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.IOException;

import encuesta.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");

        TextUserInterface userInterface = new TextUserInterface();
        userInterface.rellena(encuesta);
    }

}
