/**
 * 
 */
package curiosity.controller.comandos;

import curiosity.controller.Comando;
import curiosity.controller.RoverController;

/**
 * 
 */
public class Photo implements Comando {

	@Override
	public void execute(RoverController roverController) {
		roverController.getRover().takePhoto();
	}

}
