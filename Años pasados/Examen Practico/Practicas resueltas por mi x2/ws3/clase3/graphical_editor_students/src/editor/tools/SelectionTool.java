package editor.tools;

import editor.core.Editor;
import editor.core.Tool;
import editor.figures.Figure;

public class SelectionTool implements Tool {

	private Editor editor;
	private int x, y;
	private Figure selectedFigure;

	public SelectionTool(Editor editor) {
		if (editor == null)
			throw new IllegalArgumentException("El editor no puede ser nulo");
		this.editor = editor;
	}

	@Override
	public void release() {
		editor.trace("Se soltó la herramienta de selección");
		selectedFigure = null;
	}

	@Override
	public void clickOn(int x, int y) {
		editor.trace("Se hizo click con la herramienta de selección en " + x + ", " + y);
		selectedFigure = editor.getDrawing().findFigureAt(x, y);
		if (selectedFigure != null) {
			editor.trace("Se seleccionó la figura: " + selectedFigure);
			editor.getDrawing().setCurrentSelection(selectedFigure);
		} else {
			editor.trace("No hay ninguna figura en esa posición");
			editor.getDrawing().clearCurrentSelection();
		}
		setPosition(x, y);
	}

	private void setPosition(int x2, int y2) {
		this.x = x2;
		this.y = y2;
	}

	@Override
	public void moveTo(int x, int y) {
		if (selectedFigure == null) {
			editor.trace("Se movió el cursor a " + x + ", " + y + " y no hay ninguna figura");
			return;
		}
		editor.trace("Se arrastró con la herramienta de selección a " + x + ", " + y);
		selectedFigure.moveBy(x - this.x, y - this.y);
		editor.trace("Se movió la figura " + selectedFigure);
		setPosition(x, y);
	}

	@Override
	public void unselect() {
		selectedFigure = null;
	}

	@Override
	public String toString() {
		return "Herramienta de selección";
	}

}
