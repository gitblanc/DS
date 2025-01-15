/**
 * 
 */
package curiosity.controller.comandos;

import curiosity.controller.Comando;
import curiosity.controller.RoverController;
import curiosity.controller.UndoableComando;

/**
 * 
 */
public class Forward implements Comando, UndoableComando {

	@Override
	public void execute(RoverController roverController) {
		// se mueve una posición hacia delante salvo que se encuentre con un obstáculo
		roverController.setSuccess(roverController.getRover().moveForward());
	}

	@Override
	public void undo(RoverController roverController) {
		roverController.setSuccess(roverController.getRover().moveBackward());
	}

}
