/**
 * 
 */
package curiosity.controller.comportamientos;

import curiosity.controller.ComportamientoObstaculo;
import curiosity.controller.RoverController;

/**
 * 
 */
public class Detenerse implements ComportamientoObstaculo {

	@Override
	public boolean obstaculoEncontrado(RoverController roverController) {
		return false;
	}

}
