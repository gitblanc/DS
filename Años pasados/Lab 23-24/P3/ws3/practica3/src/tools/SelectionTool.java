package tools;

import editor.Editor;
import figures.Figure;

public class SelectionTool implements Tool {

	private Editor editor;
	private int x, y;
	private Figure selectedFigure;

	public SelectionTool(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void soltar(int x, int y) {
		selectedFigure = editor.getDibujo().buscarFigura(x, y);
		setPosicion(x, y);

	}

	private void setPosicion(int x2, int y2) {
		this.x = x2;
		this.y = y2;
	}

	@Override
	public void mover(int x, int y) {
		selectedFigure.move(x, y);
		setPosicion(x, y);
	}

	@Override
	public void pinchar(int x, int y) {
		selectedFigure = editor.getDibujo().buscarFigura(x, y);
		setPosicion(x, y);
	}

	@Override
	public String toString() {
		return "Herramienta de Selección [" + x + ", " + y + "]";
	}

}
