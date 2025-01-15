/**
 * 
 */
package editor.actions;

import java.util.ArrayList;
import java.util.List;

import editor.Editor;

/**
 * @author omenp
 *
 */
public class Macro implements Action {

	private String name;
	private List<Action> actions = new ArrayList<>();

	public Macro(String name) {
		if (name == null || name.isBlank())
			throw new IllegalArgumentException("El nombre de la macro no es válido");
		this.name = name;
	}

	public void addAction(Action a) {
		actions.add(a);
	}

	public void removeAction(Action a) {
		actions.remove(a);
	}

	public String getName() {
		return this.name;
	}

	@Override
	public void execute(Editor editor) {
		for (Action a : actions)
			a.execute(editor);
	}

}
