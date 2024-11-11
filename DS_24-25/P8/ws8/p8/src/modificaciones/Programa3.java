/**
 * 
 */
package modificaciones;

import java.io.IOException;

import encuesta.Encuesta;
import encuesta.TextUserInterface;
import encuesta.observers.GraficoCircularObserver;
import encuesta.observers.LineaEstadoObserver;
import encuesta.observers.MinimoVotosObserver;

/**
 * 
 */
public class Programa3 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");

		encuesta.addObservador(new LineaEstadoObserver());
		encuesta.addObservador(new MinimoVotosObserver(3, new GraficoCircularObserver())); // Patrón Decorator

		TextUserInterface userInterface = new TextUserInterface();
		userInterface.rellena(encuesta);
	}

}
