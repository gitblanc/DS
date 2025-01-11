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

	public MinimoVotosObserver(int i, Observer o) {
		this.minVotos = i;
		this.observer = o;
	}

	@Override
	public void update(Encuesta encuesta) {
		if (encuesta.getVotosSi() + encuesta.getVotosNo() >= this.minVotos)
			this.observer.update(encuesta);
	}

}
