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

	public IntervaloVotosObserver(int i, Observer o) {
		this.intervalo = this.contador = i;
		this.observer = o;
	}

	@Override
	public void notificar(Encuesta encuesta) {
		if (this.contador == this.intervalo) {
			this.observer.notificar(encuesta);
			this.contador = 1;
		} else
			this.contador++;
	}

}
