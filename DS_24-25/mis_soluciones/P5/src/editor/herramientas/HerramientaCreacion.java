/**
 * 
 */
package editor.herramientas;

import java.awt.Point;

import editor.cambios.CreacionCambio;
import editor.core.EditorWindow;
import editor.core.Figura;
import editor.core.Herramienta;

/**
 * Esta clase surge de la similitud de código entre HerramientaCirculo y
 * HerramientaRectangulo ---> Sólo cambian en cómo crean la figura
 */
public abstract class HerramientaCreacion implements Herramienta {

	private EditorWindow editor;
	private Point posicionInicio;

	public HerramientaCreacion(EditorWindow editorWindow) {
		this.editor = editorWindow;
	}

	@Override
	public void mousePressed(int x, int y) {
		this.posicionInicio = new Point(x, y);
	}

	@Override
	public void mouseMoved(int x, int y) {
	}

	@Override
	public void mouseReleased(int x, int y) {
		Point posFin = new Point(x, y);

		Figura figura = doCrearFigura(posicionInicio, posFin);

		editor.addFigura(figura);

		// Para el historial
		editor.getHistorialCambios().addCambio(new CreacionCambio(figura, editor.getDibujo()));

		editor.finHerramienta();
	}

	protected abstract Figura doCrearFigura(Point posicionInicio, Point posFin);

}
