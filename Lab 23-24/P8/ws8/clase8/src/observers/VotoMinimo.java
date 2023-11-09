package observers;

import encuesta.Encuesta;
import main.Observer;

public class VotoMinimo implements Observer {

	private int min;
	private Observer observer;

	public VotoMinimo(int i, Observer o1) {
		this.min = i;
		this.observer = o1;
	}

	@Override
	public void actualizar(Encuesta e) {
		// En caso de necesitar optimizar, hacerlo
		if (this.min > 1)
			this.min -= 1;
		else
			this.observer.actualizar(e);

	}

}
