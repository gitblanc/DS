package editor.tools;

import editor.core.BoundingBox;
import editor.core.Editor;
import editor.figures.Figure;
import editor.figures.Rectangle;

public class RectangleCreationTool extends AbstractCreationTool {

	public RectangleCreationTool(Editor e) {
		super(e);
	}

	@Override
	protected Figure createFigure(BoundingBox boundingBox2) {
		return new Rectangle(boundingBox2);
	}

	@Override
	public String toString() {
		return "Herramienta de creación de rectángulo";
	}
}
