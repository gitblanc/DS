/**
 * 
 */
package curiosity.controller;

import java.util.Stack;

/**
 * 
 */
public class ActionManager {

	private RoverController roverController;
	private Stack<UndoableComando> historialComandos = new Stack<>();

	public ActionManager(RoverController roverController) {
		this.roverController = roverController;
	}

	public void execute(UndoableComando comando) {
		comando.execute(roverController);
		if (roverController.getSuccess())
			historialComandos.add(comando);
	}

	public void execute(Comando comando) {
		comando.execute(roverController);
	}

	public void deshacerComandos() {
		while (!historialComandos.isEmpty()) {
			UndoableComando c = historialComandos.pop();
			c.undo(roverController); // Los elementos se eliminan de la pila
		}
	}

}
