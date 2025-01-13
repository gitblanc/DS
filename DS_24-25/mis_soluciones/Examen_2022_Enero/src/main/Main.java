package main;

import java.util.ArrayList;
import java.util.List;

import curiosity.controller.RoverController;
import curiosity.rover.Estado;
import curiosity.rover.Instruccion;
import curiosity.rover.Rover;
import curiosity.rover.instrucciones.Backward;
import curiosity.rover.instrucciones.Forward;
import curiosity.rover.instrucciones.Left;
import curiosity.rover.instrucciones.Photo;
import curiosity.rover.instrucciones.Right;
import curiosity.rover.instrucciones.Sample;
import mars.Terrain;

public class Main {

	public static void main(String[] args) {
		Rover rover = new Rover(new Terrain());
		Estado estado = new Estado(rover);
		RoverController controller = new RoverController(estado);

		List<Instruccion> task = new ArrayList<>();

		task.add(new Forward());
		task.add(new Sample());
		task.add(new Backward());
		task.add(new Left());
		task.add(new Backward());
		task.add(new Right());
		task.add(new Forward());
		task.add(new Forward());
		task.add(new Right());
		task.add(new Forward());
		task.add(new Left());
		task.add(new Forward());
		task.add(new Forward());
		task.add(new Forward());
		task.add(new Photo());
		task.add(new Sample());
		task.add(new Left());
		task.add(new Backward());
		task.add(new Photo());
		controller.executeTask(task);

		rover.transmit();
	}
}
