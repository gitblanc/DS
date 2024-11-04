/**
 * 
 */
package encuesta.observers;

import encuesta.Encuesta;
import encuesta.Observer;

/**
 * 
 */
public class BackupObserver implements Observer {

	@Override
	public void notificar(Encuesta encuesta) {
		System.out.println("Aquí se guardarán los datos en disco/BD.");
	}

}
