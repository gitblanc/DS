/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.*;

import fileSystem.FileSystem;
import filters.ContadorCaracteres;
import filters.EliminarEspaciosRepetidos;
import filters.Encrypt;
import filters.Fork;
import filters.NormalizarSaltosLinea;
import outputs.*;

public class Main {

	public static void main(String[] args) throws IOException {
		FileSystem fs = new FileSystem();

		fs.copy("privado.txt", new NormalizarSaltosLinea(new FileOutput("copia.txt")));// sin encriptar
		fs.copy("privado.txt", new Encrypt(new InternetOutput("1.1.1.1")));
		fs.copy("privado.txt", new EliminarEspaciosRepetidos(new Encrypt(new BluetoothOutput("iPhone"))));

		// MODIFICACIONES
		// 1
		fs.copy("privado.txt", new Encrypt(new NormalizarSaltosLinea(new FileOutput("copia.txt"))));// encriptando
		// 2
		fs.copy("privado.txt", new Encrypt(new NormalizarSaltosLinea(new InternetOutput("1.1.1.1"))));// normalizar y
																										// encriptar
		fs.copy("privado.txt", new Encrypt(new EliminarEspaciosRepetidos(new InternetOutput("1.1.1.1"))));// eliminar
																											// espacios
		//
		// encriptar
		// 3 y 4
		ContadorCaracteres after = new ContadorCaracteres((new InternetOutput("156.17.11.196")));
		ContadorCaracteres before = new ContadorCaracteres(new NormalizarSaltosLinea(after));
		fs.copy("privado.txt", before);
		System.out.println("Contador Internet (antes vs despues): " + before.getCont() + " -> " + after.getCont());

		after = new ContadorCaracteres((new BluetoothOutput("iPhone 13")));
		before = new ContadorCaracteres(new NormalizarSaltosLinea(after));
		fs.copy("privado.txt", before);
		System.out.println("Contador Bluetooth (antes vs despues): " + before.getCont() + " -> " + after.getCont());

		after = new ContadorCaracteres(new FileOutput("copia.txt"));
		before = new ContadorCaracteres(new EliminarEspaciosRepetidos(new NormalizarSaltosLinea(after)));
		fs.copy("privado.txt", before);
		System.out.println("Contador Internet (antes vs despues): " + before.getCont() + " -> " + after.getCont());

		// 5
		fs.copy("privado.txt",
				new Encrypt(new Fork(new InternetOutput("156.17.11.196"), new BluetoothOutput("Galaxy de Raúl"))));
	}

}
