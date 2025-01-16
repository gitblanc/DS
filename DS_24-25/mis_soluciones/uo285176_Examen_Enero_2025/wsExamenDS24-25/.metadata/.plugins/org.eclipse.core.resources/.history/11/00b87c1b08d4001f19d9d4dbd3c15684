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
public class AlinearDerecha implements BotonAlineacion {

	private Canvas canvas;

	public AlinearDerecha(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void dibujaTexto(Line line) {
		this.canvas.append(createRightAlignedLine(line));
	}

	// Método para la ampliación encargado de alinear a la derecha
	private String createRightAlignedLine(Line line) {
		var builder = new StringBuilder();
		var totalSpacesNeeded = this.canvas.getLineWidth() - line.numberOfCharacters();

		builder.append(" ".repeat(totalSpacesNeeded - line.numberOfGaps()));

		for (int i = 0; i < line.getWords().size(); i++) {
			if (i < line.numberOfWords() - 1)
				builder.append(line.getWord(i) + " ");
			else
				builder.append(line.getWord(i));
		}

		return builder.toString();
	}
}
