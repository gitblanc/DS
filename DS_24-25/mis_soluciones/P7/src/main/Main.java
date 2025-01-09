/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.IOException;

import files.FileSystem;
import filtros.FiltroContarCaracteres;
import filtros.FiltroEncriptar;
import filtros.FiltroEnvioMultiple;
import filtros.FiltroEspaciosRepetidos;
import filtros.FiltroSaltoLinea;
import outputs.BluetoothOutput;
import outputs.FileOutput;
import outputs.InternetOutput;

public class Main {

	public static void main(String[] args) throws IOException {

		FileSystem fs = new FileSystem();

		// Aquí aplicamos la Strategy
		fs.copy("privado.txt", new FileOutput("copia.txt"));
		fs.copy("privado.txt", new InternetOutput("156.17.11.196"));
		fs.copy("privado.txt", new BluetoothOutput("Galaxy de Raúl"));

		// Modificación 1: saltos de línea, encriptar y encriptar y eliminar espacios
		// repetidos
		System.out.println("MODIFICACIÓN 1");
		fs.copy("privado.txt", new FiltroSaltoLinea(new FileOutput("copia.txt")));
		fs.copy("privado.txt", new FiltroEncriptar(new InternetOutput("156.17.11.196")));
		fs.copy("privado.txt", new FiltroEncriptar(new FiltroEspaciosRepetidos(new BluetoothOutput("Galaxy de Raúl"))));

		// Modificación 2: Al enviar por Internet, además de encriptar, se quiere poder
		// indicar si hay que normalizar (quitar ‘\r’) y/o eliminar espacios repetidos
		// (una de ellas o las dos).
		System.out.println("MODIFICACIÓN 2");
		fs.copy("privado.txt", new FiltroEncriptar(new InternetOutput("1.1.1.1"))); // ENVIAR ENCRIPTANDO
		// ENVIAR ENCRIPTANDO QUITANDO SALTOS
		fs.copy("privado.txt", new FiltroEncriptar(new FiltroSaltoLinea(new BluetoothOutput("iPhone"))));
		// ENVIAR ENCRIPTANDO SIN ESPACIOS REPETIDOS
		fs.copy("privado.txt", new FiltroEncriptar(new FiltroEspaciosRepetidos(new BluetoothOutput("iPhone"))));
		// ENVIAR ENCRIPTANDO SIN ESPACIOS REPETIDOS NI SALTOS DE LINEA
		fs.copy("privado.txt",
				new FiltroEncriptar(new FiltroEspaciosRepetidos(new FiltroSaltoLinea(new BluetoothOutput("iPhone")))));

		// Modificación 3:
		// En los tres casos (tanto si se copia el fichero en disco como si se envía por
		// Internet o Bluetooth) se quiere saber, desde el Main, el número de caracteres
		// copiados.
		System.out.println("MODIFICACIÓN 3");
		FiltroContarCaracteres cFile = new FiltroContarCaracteres(new FileOutput("copia.txt"));
		FiltroContarCaracteres cInternet = new FiltroContarCaracteres(new InternetOutput("1.1.1.1"));
		FiltroContarCaracteres cBluetooth = new FiltroContarCaracteres(new BluetoothOutput("iPhone"));

		fs.copy("privado.txt", cFile);
		fs.copy("privado.txt", cInternet);
		fs.copy("privado.txt", cBluetooth);

		System.out.println("Se han enviado " + cFile.getContador() + " caracteres a copia.txt");
		System.out.println("Se han enviado " + cInternet.getContador() + " caracteres por Internet 1.1.1.1");
		System.out.println("Se han enviado " + cBluetooth.getContador() + " caracteres por Bluetooth a iPhone");

		// Modificación 4:
		// Tanto al normalizar (quitar ‘\r’) como al eliminar espacios repetidos, se
		// quiere saber también cuántos caracteres había antes del procesado.
		System.out.println("MODIFICACIÓN 4");
		FiltroContarCaracteres c4 = new FiltroContarCaracteres(
				new FiltroSaltoLinea(new FiltroEspaciosRepetidos(new BluetoothOutput("iPhone"))));
		fs.copy("privado.txt", c4);
		System.out.println("Se han enviado " + c4.getContador() + " caracteres por Bluetooth a iPhone");

		// Modificación 5:
		// Encriptar un fichero grande es una operación lenta. Se quiere que, si un
		// mismo fichero se va a mandar tanto por Internet como por Bluetooth, se
		// encripte solo una vez para ganar tiempo.
		System.out.println("MODIFICACIÓN 5");
		fs.copy("privado.txt", new FiltroEncriptar(
				new FiltroEnvioMultiple(new InternetOutput("1.1.1.1"), new BluetoothOutput("iPhone"))));
	}
}
