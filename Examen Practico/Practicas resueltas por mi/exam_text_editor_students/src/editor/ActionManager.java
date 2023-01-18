/**
 * 
 */
package editor;

import java.util.HashMap;
import java.util.Map;

import editor.actions.Action;
import editor.actions.Macro;

/**
 * @author omenp
 *
 */
public class ActionManager {

	private Editor editor;
	private boolean recordingMacro;
	private Macro macro;
	private Map<String, Macro> macros = new HashMap<>();

	public ActionManager(Editor editor) {
		if (editor == null)
			throw new IllegalArgumentException("Se necesita una referencia al editor");
		this.editor = editor;
	}

	public void execute(Action action) {
		action.execute(editor);
		if (recordingMacro) {
			macro.addAction(action);
		}
	}

	public void record(String macro) {
		this.macro = new Macro(macro);
		recordingMacro = true;
	}

	public void stop() {
		if (!recordingMacro)
			return;
		recordingMacro = false;
		this.macros.put(macro.getName(), macro);
	}

	public void executeMacro(String macro) {
		Macro m = macros.get(macro);
		if (m == null) {
			System.out.println("La macro especificada no existe");
			return;
		}
		execute(m);

	}

}
