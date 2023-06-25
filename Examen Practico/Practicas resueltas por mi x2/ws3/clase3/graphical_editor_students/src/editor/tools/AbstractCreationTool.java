package editor.tools;

import editor.core.BoundingBox;
import editor.core.Editor;
import editor.core.Tool;
import editor.figures.Figure;

public abstract class AbstractCreationTool implements Tool {

	private Editor editor;
	private BoundingBox boundingBox;

	protected AbstractCreationTool(Editor e) {
		if (e == null)
			throw new IllegalArgumentException("El editor no puede ser nulo");
		this.editor = e;
	}

	@Override
	public void release() {
		if (boundingBox == null) {
			editor.trace("No hay un punto previamente pulsado");
			return;
		}
		Figure newFigure = createFigure(boundingBox);
		editor.getDrawing().addFigure(newFigure);
		editor.trace("Se creó la figura " + newFigure);
		editor.toolDone();
		boundingBox = null;
	}

	protected abstract Figure createFigure(BoundingBox boundingBox2);

	@Override
	public void clickOn(int x, int y) {
		editor.getDrawing().clearCurrentSelection();
		editor.trace("Comenzando a crear área rectangular");
		boundingBox = new BoundingBox(x, y);
	}

	@Override
	public void moveTo(int x, int y) {
		if (boundingBox == null) {
			editor.trace("Se movió el cursor pero sin efecto");
			return;
		}
		editor.trace("Se movió el cursor a la posición " + x + ", " + y);
		boundingBox.resizeTo(x, y);
		editor.trace("El área actual de la herramienta es: " + boundingBox);
	}

	@Override
	public void unselect() {
		boundingBox = null;
	}
}
