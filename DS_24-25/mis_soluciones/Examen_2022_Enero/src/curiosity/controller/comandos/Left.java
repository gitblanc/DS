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
public class Left implements Comando, UndoableComando {

	@Override
	public void execute(RoverController roverController) {
		roverController.getRover().turnLeft();
	}

	@Override
	public void undo(RoverController roverController) {
		roverController.getRover().turnRight();
	}

}
