package observers;

import encuesta.Encuesta;
import main.Observer;

public class GraficoBarras implements Observer {

	@Override
	public void actualizar(Encuesta e) {
		System.out.println("Aquí se dibujaría el gráfico de barras.");
	}

}
