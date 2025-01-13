package curiosity.controller.command;

import curiosity.rover.Rover;

public class MoveFordwardCommand implements UndoableCommand {
	
	/*
	 * Clase añadida para la parte 1 (volver inicio)
	 * Se trata del patrón Command y esta interfaz correspondería con uno de los múltiples ConcreteCommand
	 */
	
	//Patrón Command Participante Receiver
	private Rover rover;

	public MoveFordwardCommand(Rover rover) {
		this.rover = rover;
	}

	//Patrón Command corresponde método execute
	@Override
	public void undo() {
		rover.moveBackward();
	}

}
