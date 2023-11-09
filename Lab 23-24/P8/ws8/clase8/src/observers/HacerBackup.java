package observers;

import encuesta.Encuesta;
import main.Observer;

public class HacerBackup implements Observer {

	@Override
	public void actualizar(Encuesta e) {
		System.out.println("Aquí se guardarán los datos en disco/BD.");
	}

}
