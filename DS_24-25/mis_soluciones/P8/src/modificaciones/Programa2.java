/**
 * 
 */
package modificaciones;

import java.io.IOException;

import encuesta.Encuesta;
import encuesta.TextUserInterface;
import encuesta.observers.BackupObserver;
import encuesta.observers.GraficoCircularObserver;
import encuesta.observers.LineaEstadoObserver;

/**
 * 
 */
public class Programa2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");

		encuesta.addObservador(new GraficoCircularObserver());
		encuesta.addObservador(new BackupObserver());
		encuesta.addObservador(new LineaEstadoObserver());

		TextUserInterface userInterface = new TextUserInterface();
		userInterface.rellena(encuesta);
	}

}
