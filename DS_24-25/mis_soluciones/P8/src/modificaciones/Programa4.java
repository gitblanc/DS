/**
 * 
 */
package modificaciones;

import java.io.IOException;

import encuesta.Encuesta;
import encuesta.TextUserInterface;
import encuesta.observers.GraficoBarrasObserver;
import encuesta.observers.IntervaloVotosObserver;
import encuesta.observers.LineaEstadoObserver;

/**
 * 
 */
public class Programa4 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");

		encuesta.addObservador(new LineaEstadoObserver());
		encuesta.addObservador(new IntervaloVotosObserver(3, new GraficoBarrasObserver()));

		TextUserInterface userInterface = new TextUserInterface();
		userInterface.rellena(encuesta);
	}

}
