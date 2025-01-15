/**
 * 
 */
package editor.actions;

import java.util.Stack;

/**
 * @author blanc
 *
 */
public class ActionManager {

	private Stack<Action> undoableActions = new Stack<>();
	private Stack<Action> redoableActions = new Stack<>();

	public void executeAction(Action action) {
		action.execute();
		addUndoableAction(action);
	}

	public void addUndoableAction(Action action) {
		redoableActions.clear();
		undoableActions.push(action);
	}

	public void undo() {
		if (undoableActions.isEmpty())
			System.out.println("No hay acciones que deshacer");
		else {
			Action action = undoableActions.pop();
			action.undo();
			redoableActions.push(action);
		}
	}

	public void redo() {
		if (redoableActions.isEmpty())
			System.out.println("No hay acciones que rehacer");

		Action action = redoableActions.pop();
		action.execute();
		undoableActions.push(action);
	}

}
