/**
 * 
 */
package encuesta.observers;

import encuesta.Encuesta;
import encuesta.Observer;

/**
 * 
 */
public class GraficoBarrasObserver implements Observer {

	@Override
	public void update(Encuesta encuesta) {
		System.out.println("Aquí se dibujaría el gráfico de barras.");
	}

}
