package curiosity.controller;

import java.util.List;

import curiosity.controller.comandos.Backward;
import curiosity.controller.comandos.Forward;
import curiosity.controller.comandos.Left;
import curiosity.controller.comandos.Photo;
import curiosity.controller.comandos.Right;
import curiosity.controller.comandos.Sample;
import curiosity.rover.Rover;

public class RoverController {

	private ActionManager actionManager;
	private Rover rover;
	private int ip;
	private boolean success;
	private ComportamientoObstaculo comportamientoObstaculo;

	public RoverController(Rover rover, ComportamientoObstaculo comp) {
		this.rover = rover;
		this.actionManager = new ActionManager(this);
		this.comportamientoObstaculo = comp;
	}

	public boolean executeTask(List<String> task) {

		success = true;
		UndoableComando c;

		while (ip < task.size() && success) {
			String instruction = task.get(ip);

			if (instruction.equals("forward")) {
				c = new Forward();
				actionManager.execute(c);
			} else if (instruction.equals("backward")) {
				c = new Backward();
				actionManager.execute(c);
			} else if (instruction.equals("left")) {
				c = new Left();
				actionManager.execute(c);
			} else if (instruction.equals("right")) {
				c = new Right();
				actionManager.execute(c);
			} else if (instruction.equals("sample")) {
				actionManager.execute(new Sample());
			} else if (instruction.equals("photo")) {
				actionManager.execute(new Photo());
			} else {
				rover.trace("Unknown instruction!");
			}

			if (success)
				ip++;
			else
				setSuccess(comportamientoObstaculo.obstaculoEncontrado(this));
		}

		if (success)
			rover.trace("Task finished");
		else {
			rover.trace("Task couldn't have been completed");
		}

		return success;
	}

	public Rover getRover() {
		return this.rover;
	}

	public void setSuccess(boolean c) {
		this.success = c;
	}

	public boolean getSuccess() {
		return this.success;
	}

	public int getIp() {
		return this.ip;
	}

	public void setIp(int i) {
		this.ip = i;
	}

	public void deshacerComandos() {
		actionManager.deshacerComandos();
	}
}
