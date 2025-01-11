/**
 * 
 */
package encuesta.observers;

import encuesta.Encuesta;
import encuesta.Observer;

/**
 * 
 */
public class LineaEstadoObserver implements Observer {

	@Override
	public void update(Encuesta encuesta) {
		System.out.println("Nº de votos SI = " + encuesta.getVotosSi() + ". Nº de votos NO = " + encuesta.getVotosNo());
	}

}
