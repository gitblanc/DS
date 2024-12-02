package editor.actions;

import editor.Editor;
import java.util.ArrayList;
import java.util.List;

public class Macro implements Action {

	private String nombre;

	private List<Action> acciones = new ArrayList<>();

	public Macro(String nombreMacro) {
		this.nombre = nombreMacro;
	}

	@Override
	public void execute(Editor editor) {
		for (Action accion : acciones) {
			accion.execute(editor);
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public void addAction(Action action) {
		acciones.add(action);
	}

}
