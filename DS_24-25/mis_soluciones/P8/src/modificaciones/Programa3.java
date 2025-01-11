/**
 * 
 */
package modificaciones;

import java.io.IOException;

import encuesta.Encuesta;
import encuesta.TextUserInterface;
import encuesta.observers.IntervaloVotosObserver;
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

		TextUserInterface userInterface = new TextUserInterface();

		encuesta.addObserver(new MinimoVotosObserver(4, new IntervaloVotosObserver(2, new LineaEstadoObserver())));

		userInterface.rellena(encuesta);
	}

}
