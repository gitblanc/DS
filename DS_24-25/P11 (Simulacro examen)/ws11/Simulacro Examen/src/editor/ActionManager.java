package editor;

import editor.actions.Action;
import editor.actions.Macro;
import java.util.HashMap;
import java.util.Map;

public class ActionManager {

	private Editor editor;
	private Macro macro;
	private boolean recordingMacro;
	private Map<String, Macro> macros = new HashMap<>();

	public ActionManager(Editor editor) {
		this.editor = editor;
	}

	public void execute(Action action) {
		action.execute(this.editor);
		if (recordingMacro) {
			macro.addAction(action);
		}
	}

	// La ampliación

	public void grabar(String nombreMacro) {
		macro = new Macro(nombreMacro);
		recordingMacro = true;
	}

	public void pararDeGrabar() {
		if (!recordingMacro)
			return;
		recordingMacro = false;
		macros.put(macro.getNombre(), macro);
	}

	public void ejecutarMacro(String nombre) {
		Macro m = macros.get(nombre);
		if (m == null) {
			System.out.println("Macro " + nombre + " no encontrada");
			return;
		}
		execute(macro);
	}
}
