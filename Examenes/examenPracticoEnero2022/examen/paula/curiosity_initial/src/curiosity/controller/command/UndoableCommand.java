package curiosity.controller.command;


public interface UndoableCommand {
	
	/*
	 * Interface añadida para la parte 1 (volver inicio)
	 * Se trata del patrón Command y esta interfaz correspondería con el participante Command
	 */
	
	//Patrón Command corresponde método execute
	public void undo();

}
