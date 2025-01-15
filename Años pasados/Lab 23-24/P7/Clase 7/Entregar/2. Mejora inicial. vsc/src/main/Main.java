/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.*;

import fileSystem.FileSystem;
import outputs.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FileSystem fs = new FileSystem();

        fs.copy("privado.txt", new FileOutput("copia.txt"));
        fs.copy("privado.txt", new InternetOutput("1.1.1.1"));
        fs.copy("privado.txt", new BluetoothOutput("iPhone"));
    }

}
