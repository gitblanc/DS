/**
 * 
 */
package editor;

import java.util.HashMap;
import java.util.Map;

import editor.comandos.Macro;

/**
 * 
 */
public class ActionManager {

	private Editor editor;
	private boolean isRecording = false;
	private Macro macro;
	private Map<String, Macro> macros = new HashMap<String, Macro>();

	public ActionManager(Editor editor) {
		this.editor = editor;
	}

	public void execute(Comando comando) {
		comando.execute(editor);
		if (isRecording)
			macro.addComando(comando);
	}

	public void grabar(String nombreMacro) {
		this.isRecording = true;
		macro = new Macro(nombreMacro);
	}

	public void pararDeGrabar() {
		if (!isRecording)
			return;
		this.isRecording = false;
		macros.put(macro.getNombre(), macro);
	}

	public void ejecutaMacro(String nombre) {
		Macro m = macros.get(nombre);
		if (m == null) {
			System.out.println("Macro " + nombre + " no encontrada");
			return;
		}
		execute(m);
	}

}
