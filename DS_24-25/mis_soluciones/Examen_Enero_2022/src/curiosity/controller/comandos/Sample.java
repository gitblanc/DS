/**
 * 
 */
package curiosity.controller.comandos;

import curiosity.controller.Comando;
import curiosity.controller.RoverController;

/**
 * 
 */
public class Sample implements Comando {

	@Override
	public void execute(RoverController roverController) {
		roverController.getRover().takeSample();
	}

}
