/**
 * 
 */
package curiosity.controller.comportamientos;

import curiosity.controller.ComportamientoObstaculo;
import curiosity.controller.RoverController;

/**
 * 
 */
public class SaltarSiguiente implements ComportamientoObstaculo {

	@Override
	public boolean obstaculoEncontrado(RoverController roverController) {
		roverController.setIp(roverController.getIp() + 1);
		return true;
	}

}
