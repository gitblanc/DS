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
public class Right implements Comando, UndoableComando {

	@Override
	public void execute(RoverController roverController) {
		roverController.getRover().turnRight();
	}

	@Override
	public void undo(RoverController roverController) {
		roverController.getRover().turnLeft();
	}

}
