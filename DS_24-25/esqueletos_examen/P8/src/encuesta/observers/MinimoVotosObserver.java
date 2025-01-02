/**
 * 
 */
package encuesta.observers;

import encuesta.Encuesta;
import encuesta.Observer;

/**
 * 
 */
public class MinimoVotosObserver implements Observer {

	private int minVotos;
	private Observer observer;

	public MinimoVotosObserver(int votos, Observer o) {
		this.minVotos = votos;
		this.observer = o;
	}

	@Override
	public void notificar(Encuesta encuesta) {
		if (encuesta.getVotosSi() + encuesta.getVotosNo() >= this.minVotos)
			this.observer.notificar(encuesta);
	}

}
