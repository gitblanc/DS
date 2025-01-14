/**
 * 
 */
package curiosity.controller.comportamientos;

import curiosity.controller.ComportamientoObstaculo;
import curiosity.controller.RoverController;

/**
 * 
 */
public class VolverInicio implements ComportamientoObstaculo {

	@Override
	public boolean obstaculoEncontrado(RoverController roverController) {
		roverController.deshacerComandos();
		return false;
	}

}
