package observers;

import encuesta.Encuesta;
import main.Observer;

public class LineaEstado implements Observer {

	@Override
	public void actualizar(Encuesta e) {
		System.out.println("Nº de votos de SI = " + e.getVotosSi() + ". Nº de votos de NO = " + e.getVotosNo());
	}

}
