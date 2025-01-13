package curiosity.controller;

import java.util.List;

import curiosity.rover.Estado;
import curiosity.rover.Instruccion;

public class RoverController {

	private Estado estado;

	public RoverController(Estado e) {
		this.estado = e;
	}

	public boolean executeTask(List<Instruccion> task) {

		while (estado.getIp() < task.size() && estado.getSuccess()) {
			Instruccion instruccion = task.get(estado.getIp());
			instruccion.execute(this.estado);

			if (estado.getSuccess())
				estado.updateIp();
		}

		if (estado.getSuccess())
			estado.getRover().trace("Task finished");
		else
			estado.getRover().trace("Task couldn't have been completed");

		return estado.getSuccess();
	}
}
