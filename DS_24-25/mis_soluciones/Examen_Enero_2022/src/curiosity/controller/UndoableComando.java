package curiosity.controller;

public interface UndoableComando extends Comando {

	void undo(RoverController roverController);

}
