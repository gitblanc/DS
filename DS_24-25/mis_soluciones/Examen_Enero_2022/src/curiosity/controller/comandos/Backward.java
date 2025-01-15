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
public class Backward implements Comando, UndoableComando {

	@Override
	public void execute(RoverController roverController) {
		// se mueve una posición hacia atrás salvo que se encuentre con un obstáculo
		roverController.setSuccess(roverController.getRover().moveBackward());
	}

	@Override
	public void undo(RoverController roverController) {
		roverController.setSuccess(roverController.getRover().moveForward());
	}

}
