/**
 * 
 */
package encuesta.observers;

import encuesta.Encuesta;
import encuesta.Observer;

/**
 * 
 */
public class IntervaloVotosObserver implements Observer {

	private int intervalo, contador;
	private Observer observer;

	public IntervaloVotosObserver(int interv, Observer o) {
		this.intervalo = this.contador = interv;
		this.observer = o;
	}

	@Override
	public void update(Encuesta encuesta) {
		if (intervalo == contador) {
			observer.update(encuesta);
			contador = 1;
		} else
			contador += 1;
	}

}
