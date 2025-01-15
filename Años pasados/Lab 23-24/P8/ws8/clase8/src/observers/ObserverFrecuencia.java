package observers;

import encuesta.Encuesta;
import main.Observer;

public class ObserverFrecuencia implements Observer {

	private int freq, cont;
	private Observer observer;

	public ObserverFrecuencia(int i, Observer o1) {
		this.freq = this.cont = i;
		this.observer = o1;
	}

	@Override
	public void actualizar(Encuesta e) {
		if (cont == freq) {
			this.observer.actualizar(e);
			cont = 1;
		}
		cont += 1;
	}

}
