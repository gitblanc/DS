package editor.tools;

import editor.core.Editor;
import editor.core.Tool;
import editor.figures.Triangle;

public class TriangleCreationTool implements Tool {

	private Editor editor;
	private int x1, y1, x2, y2, x3, y3;
	private int vertices;

	public TriangleCreationTool(Editor editor) {
		if (editor == null)
			throw new IllegalArgumentException("El editor no puede ser nulo");
		this.editor = editor;
	}

	@Override
	public void release() {

	}

	@Override
	public void clickOn(int x, int y) {
		vertices++;
		if (vertices == 1) {
			editor.getDrawing().clearCurrentSelection();
			x1 = x;
			y1 = y;
		} else if (vertices == 2) {
			x2 = x;
			y2 = y;
		} else if (vertices == 3) {
			x3 = x;
			y3 = y;
			editor.getDrawing().addFigure(new Triangle(x1, y1, x2, y2, x3, y3));
			vertices = 0;
			editor.toolDone();
		}
	}

	@Override
	public void moveTo(int x, int y) {
	}

	@Override
	public void unselect() {
		vertices = 0;
	}

	@Override
	public String toString() {
		return "Herramienta de creación de triángulo";
	}

}
