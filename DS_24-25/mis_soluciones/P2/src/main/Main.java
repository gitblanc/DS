package main;

/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	private static MaquinaVirtual vm = new MaquinaVirtual();

	public static void main(String[] args) throws Exception {
		BufferedReader fichero = new BufferedReader(new FileReader("factorial.txt"));
		// BufferedReader fichero = new BufferedReader(new FileReader("fibonacci.txt"));

		String linea;
		while ((linea = fichero.readLine()) != null)
			vm.cargaInstruccion(linea);
		fichero.close();

		vm.ejecutaPrograma();
	}

}
