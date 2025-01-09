/**
 * 
 */
package editor.figuras.circulo;

import java.awt.Point;

import editor.core.EditorWindow;
import editor.core.Figura;
import editor.herramientas.HerramientaCreacion;

/**
 * 
 */
public class HerramientaCirculo extends HerramientaCreacion {

	public HerramientaCirculo(EditorWindow editorWindow) {
		super(editorWindow);
	}

	@Override
	protected Figura doCrearFigura(Point posicionInicio, Point posFin) {
		Point centro = new Point((posicionInicio.x + posFin.x) / 2, (posicionInicio.y + posFin.y) / 2);
		int radio = Math.max(posFin.x - posicionInicio.x, posFin.y - posicionInicio.y) / 2;
		return new Circulo(centro, radio);
	}

}
