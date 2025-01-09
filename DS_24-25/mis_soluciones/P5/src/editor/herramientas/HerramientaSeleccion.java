/**
 * 
 */
package editor.herramientas;

import java.awt.Point;

import editor.cambios.MoverCambio;
import editor.core.EditorWindow;
import editor.core.Figura;
import editor.core.Herramienta;

/**
 * 
 */
public class HerramientaSeleccion implements Herramienta {

	private EditorWindow editor;
	private Figura seleccionada;
	private Point posicionAnterior;

	public HerramientaSeleccion(EditorWindow editorWindow) {
		this.editor = editorWindow;
	}

	@Override
	public void mousePressed(int x, int y) {
		seleccionada = editor.getDibujo().getFigura(x, y);
		posicionAnterior = new Point(x, y);
	}

	@Override
	public void mouseMoved(int x, int y) {
		mueve(x, y);
	}

	@Override
	public void mouseReleased(int x, int y) {
		mueve(x, y);

		if (this.seleccionada != null) {
			this.editor.getHistorialCambios()
					.addCambio(new MoverCambio(this.seleccionada, posicionAnterior.x - x, posicionAnterior.y - y));
		}
	}

	private void mueve(int x, int y) {
		if (seleccionada != null) {
			seleccionada.mover(x - posicionAnterior.x, y - posicionAnterior.y);
			posicionAnterior = new Point(x, y);
		}
	}
}
