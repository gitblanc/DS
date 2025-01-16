/**
 * 
 */
package gui.botones;

import gui.BotonAlineacion;
import gui.Canvas;
import model.Line;

/**
 * 
 */
public class AlinearIzquierda implements BotonAlineacion {

	private Canvas canvas;

	public AlinearIzquierda(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void dibujaTexto(Line line) {
		this.canvas.append(line.getContent());
	}

}
