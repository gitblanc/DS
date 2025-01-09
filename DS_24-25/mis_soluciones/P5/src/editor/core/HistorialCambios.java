/**
 * 
 */
package editor.core;

import java.util.Stack;

/**
 * 
 */
public class HistorialCambios {

	private Stack<Cambio> undoableCambios = new Stack<Cambio>();
	private Stack<Cambio> redoableCambios = new Stack<Cambio>();

	public void undo() {
		if (undoableCambios.isEmpty())
			System.out.println("No hay acciones que deshacer");
		else {
			Cambio cambio = undoableCambios.pop();
			cambio.undo();
			redoableCambios.push(cambio);
		}
	}

	public void redo() {
		if (redoableCambios.isEmpty())
			System.out.println("No hay acciones que rehacer");
		else {
			Cambio cambio = redoableCambios.pop();
			cambio.redo();
			undoableCambios.push(cambio);
		}
	}

	public void addCambio(Cambio cambio) {
		redoableCambios.clear();
		this.undoableCambios.push(cambio);
	}

}
