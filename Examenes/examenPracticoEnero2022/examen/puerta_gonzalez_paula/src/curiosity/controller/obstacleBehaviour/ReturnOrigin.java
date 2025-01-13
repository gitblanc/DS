package curiosity.controller.obstacleBehaviour;

import curiosity.controller.RoverController;
import curiosity.controller.command.UndoableCommand;

public class ReturnOrigin implements ObstacleBehaviour {

	/*
	 * Clase añadida para la parte 2 (diferentes políticas ante los obstaculos)
	 * Se trata del patrón Strategy y esta interfaz correspondería con uno de los distintos ConcreteStrategy
	 */

	
	//Patrón Strategy correponde al método algorithm
	@Override
	public boolean foundObstacle(RoverController roverController) {
		for(UndoableCommand ut : roverController.getUndoableTasks()) {
			ut.undo();
		}
		return false;
	}

}
