/**
 * 
 */
package editor.actions;

import java.util.Stack;

/**
 * @author omenp
 *
 */
public class ActionManager {
	private Stack<Action> undoableActions = new Stack<>();
	private Stack<Action> redoableActions = new Stack<>();

	public void executeAction(Action a) {
		a.execute();
		addUndoableAction(a);
	}

	private void clear() {
		redoableActions.clear();
	}

	private void addUndoableAction(Action a) {
		clear();
		undoableActions.push(a);
	}
	
	public boolean canBeUndone()
	{
		return !undoableActions.isEmpty();
	}
	
	public void undo() {
		if (!canBeUndone())
			throw new IllegalStateException("No hay acciones que deshacer");
		Action a = undoableActions.pop();
		a.undo();
		redoableActions.push(a);
	}
	
	public boolean canBeRedone()
	{
		return !redoableActions.isEmpty();
	}
	
	public void redo()
	{
		if (!canBeRedone())
			throw new IllegalStateException("No hay ninguna operación que repetir");
		Action action = redoableActions.pop();
		action.execute();
		undoableActions.push(action);
	}
}
