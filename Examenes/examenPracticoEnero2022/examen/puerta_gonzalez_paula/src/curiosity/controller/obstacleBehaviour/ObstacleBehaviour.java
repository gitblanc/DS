package curiosity.controller.obstacleBehaviour;

import curiosity.controller.RoverController;

public interface ObstacleBehaviour {
	
	/*
	 * Interface añadida para la parte 2 (diferentes políticas ante los obstaculos)
	 * Se trata del patrón Strategy y esta interfaz correspondería con el participante Strategy
	 */
	
	//Patrón Strategy correponde al método algorithm
	public boolean foundObstacle(RoverController roverController);

}
