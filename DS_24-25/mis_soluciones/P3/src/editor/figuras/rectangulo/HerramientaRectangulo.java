/**
 * 
 */
package editor.figuras.rectangulo;

import java.awt.Point;

import editor.core.EditorWindow;
import editor.core.Figura;
import editor.herramientas.HerramientaCreacion;

/**
 * 
 */
public class HerramientaRectangulo extends HerramientaCreacion {

	public HerramientaRectangulo(EditorWindow editorWindow) {
		super(editorWindow);
	}

	@Override
	protected Figura doCrearFigura(Point posicionInicio, Point posFin) {
		return new Rectangulo(posicionInicio, posFin);
	}

}
