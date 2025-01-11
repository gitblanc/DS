/**
 * 
 */
package modificaciones;

import java.io.IOException;

import encuesta.Encuesta;
import encuesta.TextUserInterface;
import encuesta.observers.BackupObserver;
import encuesta.observers.GraficoBarrasObserver;
import encuesta.observers.GraficoCircularObserver;
import encuesta.observers.LineaEstadoObserver;

/**
 * 
 */
public class Programa1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");

        TextUserInterface userInterface = new TextUserInterface();
        
        encuesta.addObserver(new GraficoCircularObserver());
        encuesta.addObserver(new GraficoBarrasObserver());
        encuesta.addObserver(new BackupObserver());
        encuesta.addObserver(new LineaEstadoObserver());
        
        userInterface.rellena(encuesta);
	}

}
