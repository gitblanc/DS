/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.*;

import files.FileSystem;
import outputs.*;
import outputs.filters.FiltroContarCaracteres;
import outputs.filters.FiltroEliminarEspacios;
import outputs.filters.FiltroEncriptar;
import outputs.filters.FiltroEnvioMultiple;
import outputs.filters.FiltroSaltoLinea;

public class Main {

	public static void main(String[] args) throws IOException {

		FileSystem fs = new FileSystem();

		fs.copy("privado.txt", new FileOutput("copia.txt"));
		fs.copy("privado.txt", new InternetOutput("1.1.1.1"));
		fs.copy("privado.txt", new BluetoothOutput("iPhone"));

		// Diseño de Referencia:
		// FiltroSaltoLinea: Cuando se hace una copia de un fichero en disco (lo que
		// anteriormente hacía
		// copyFile), se quiere normalizar los saltos de línea (quitar ‘\r’ y dejar solo
		// los ‘\n’).
		System.out.println("DISEÑO DE REFERENCIA");

		fs.copy("privado.txt", new FiltroSaltoLinea(new FileOutput("copia.txt")));

		// FiltroEncriptar: Al mandar por Internet, se quiere encriptar (+1 si es letra
		// o dígito).
		fs.copy("privado.txt", new FiltroEncriptar(new InternetOutput("1.1.1.1")));

		// FiltroEliminarEspacios: Al mandar por Bluetooth, se quiere encriptar (de
		// igual forma que antes) y eliminar espacios repetidos.
		fs.copy("privado.txt", new FiltroEncriptar(new FiltroEliminarEspacios(new BluetoothOutput("iPhone"))));

		// Modificación 1:
		// Cuando se hace una copia de un fichero en disco (lo que anteriormente hacía
		// copyFile), además de normalizar saltos de línea (quitar ‘\r’), hay veces que
		// también se querrá encriptar. En el main se debería poder indicar si, al hacer
		// la copia, se quiere encriptar o no.
		System.out.println("MODIFICACIÓN 1");
		fs.copy("privado.txt", new FiltroSaltoLinea(new FileOutput("copia.txt"))); // SIN ENCRIPTAR
		fs.copy("privado.txt", new FiltroSaltoLinea(new FiltroEncriptar(new FileOutput("copia.txt")))); // ENCRIPTADO

		// Modificación 2:
		// Al enviar por Internet, además de encriptar, se quiere poder indicar si hay
		// que normalizar (quitar ‘\r’) y/o eliminar espacios repetidos (una de ellas o
		// las dos).
		System.out.println("MODIFICACIÓN 2");
		fs.copy("privado.txt", new FiltroEncriptar(new InternetOutput("1.1.1.1"))); // ENVIAR ENCRIPTANDO
		// ENVIAR ENCRIPTANDO QUITANDO SALTOS
		fs.copy("privado.txt", new FiltroEncriptar(new FiltroSaltoLinea(new BluetoothOutput("iPhone"))));
		// ENVIAR ENCRIPTANDO SIN ESPACIOS REPETIDOS
		fs.copy("privado.txt", new FiltroEncriptar(new FiltroEliminarEspacios(new BluetoothOutput("iPhone"))));
		// ENVIAR ENCRIPTANDO SIN ESPACIOS REPETIDOS NI SALTOS DE LINEA
		fs.copy("privado.txt",
				new FiltroEncriptar(new FiltroEliminarEspacios(new FiltroSaltoLinea(new BluetoothOutput("iPhone")))));

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
				new FiltroSaltoLinea(new FiltroEliminarEspacios(new BluetoothOutput("iPhone"))));
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
