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
public class Centrado implements BotonAlineacion {

	private Canvas canvas;

	public Centrado(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void dibujaTexto(Line line) {
		this.canvas.append(createCenteredLine(line));
	}

	// Método para la ampliación encargado de centrar el texto
	private String createCenteredLine(Line line) {
		var builder = new StringBuilder();
		var totalSpacesNeeded = this.canvas.getLineWidth() - line.numberOfCharacters();

		builder.append(" ".repeat((totalSpacesNeeded - line.numberOfGaps()) / 2));

		for (int i = 0; i < line.getWords().size(); i++) {
			if (i < line.numberOfWords() - 1)
				builder.append(line.getWord(i) + " ");
			else
				builder.append(line.getWord(i));
		}
		
		builder.append(" ".repeat((totalSpacesNeeded - line.numberOfGaps()) / 2));

		return builder.toString();
	}
}
