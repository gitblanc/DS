/**
 * 
 */
package editor.actions;

import editor.core.Figure;

/**
 * @author omenp
 *
 */
public class MoveFigureAction implements Action {

	private Figure figure;
	private int x, y;

	public MoveFigureAction(Figure f, int dx, int dy) {
		if (figure == null)
			throw new IllegalArgumentException(
					"La acción de crear figura necesita la nueva figura a añadir al documento");
		this.figure = f;
		this.x = dx;
		this.y = dy;
	}

	@Override
	public void execute() {
		figure.moveBy(x, y);
	}

	@Override
	public void undo() {
		figure.moveBy(-x, -y);
	}

	@Override
	public String toString() {
		return String.format("Mover la figura %s %d píxeles en horizontal y %d en vertical", figure, x, y);
	}

}
