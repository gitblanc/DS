package curiosity.controller;

import java.util.ArrayList;
import java.util.List;

import curiosity.controller.command.*;
import curiosity.controller.obstacleBehaviour.ObstacleBehaviour;
import curiosity.rover.Rover;



public class RoverController {
	
	/*
	 * En la primera parte del examen (volver al inicio) se aplica el patrón Command,
	 * la clase actual RoverController sería el Invoker
	 * 
	 * En la segunda parte del examen (obstaculos) se aplica el patrón Strategy,
	 * la clase RoverController sería el Context
	 */
	
	//Cambio parte 2 (obstáculos)
	public RoverController(Rover rover, ObstacleBehaviour obstacleBehaviour) {
		this.rover = rover;
		//Cambio parte 1 (volver inicio)
		undoableTasks = new ArrayList<UndoableCommand>();
		//Cambio parte 2 (obstáculos)
		this.obstacleBehaviour = obstacleBehaviour;
	}
		
	
	public boolean executeTask(List<String> task) {
		
		boolean success = true;
		
		while (ip < task.size() && success) {
			String instruction = task.get(ip);
			
			//Cambio parte 1 (volver inicio)
			UndoableCommand uc = null;
				
			if (instruction.equals("forward")) {
				// se mueve una posición hacia delante salvo que se encuentre con un obstáculo
				success = rover.moveForward();
				//Cambio parte 1 (volver inicio)
				uc = new MoveFordwardCommand(rover);
			} else if (instruction.equals("backward")) {
				// se mueve una posición hacia atrás salvo que se encuentre con un obstáculo
				success = rover.moveBackward();
				//Cambio parte 1 (volver inicio)
				uc = new MoveBackwardCommand(rover);
			} else if (instruction.equals("left")) {
				rover.turnLeft();
				//Cambio parte 1 (volver inicio)
				uc = new RotateLeftCommand(rover);
			} else if (instruction.equals("right")) {
				rover.turnRight();
				//Cambio parte 1 (volver inicio)
				uc = new RotateRightCommand(rover);
			} else if (instruction.equals("sample")) {
				rover.takeSample();
			} else if (instruction.equals("photo")) {
				rover.takePhoto();
			} else {
				rover.trace("Unknown instruction!");				
			}
			
			if (success) {
				ip++;
				//Cambio parte 1 (volver inicio)
				if(uc != null)
					addUndoableTask(uc);
			} else {
				//Cambio parte 2 (obstáculos) llamada al algorithm del ConcreteStrategy que tenga asignado
				success = obstacleBehaviour.foundObstacle(this);
			}
		}
		
		if (success)
			rover.trace("Task finished");
		else
			rover.trace("Task couldn't have been completed");

		return success;
	}
	
	//Cambio parte 1 (volver inicio)
	private void addUndoableTask(UndoableCommand undoableTask) {
		undoableTasks.add(0, undoableTask);
	}
	
	//Cambio parte 1 (volver inicio)
	private void undoDoneTasks() {
		for(UndoableCommand uc : undoableTasks) {
			uc.undo();
		}
	}
	
	//Cambio parte 2 (obstaculos)
	public void jumpNextTask() {
		ip++;
	}
	
	//Cambio parte 2 (obstaculos)
	public List<UndoableCommand> getUndoableTasks() {
		return undoableTasks;
	}

	private Rover rover;
	private int ip;		
	
	//Cambio parte 1 (volver inicio)
	private List<UndoableCommand> undoableTasks;
	
	//Cambio parte 2 (obstaculos)
	//Patrón Strategy, este atributo se corresponde con el strategy del Context
	private ObstacleBehaviour obstacleBehaviour;
	
}
