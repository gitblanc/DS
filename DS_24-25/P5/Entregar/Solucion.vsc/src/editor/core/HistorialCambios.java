package editor.core;

import java.util.Stack;

import editor.cambios.Cambio;

public class HistorialCambios {

	private Stack<Cambio> undoableActions = new Stack<>();
	private Stack<Cambio> redoableActions = new Stack<>();

	public void undo() {
		if (undoableActions.isEmpty())
			System.out.println("No hay acciones que deshacer");
		else {
			Cambio action = undoableActions.pop();
			action.undo();
			redoableActions.push(action);
		}
	}

	public void redo() {
		if (redoableActions.isEmpty())
			System.out.println("No hay acciones que rehacer");
		else {
			Cambio action = redoableActions.pop();
			action.redo();
			undoableActions.push(action);
		}
	}

	public void addCambio(Cambio action) {
		redoableActions.clear();
		undoableActions.push(action);
	}

}
