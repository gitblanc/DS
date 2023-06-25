package editor.tools;

import editor.core.BoundingBox;
import editor.core.Editor;
import editor.figures.Circle;
import editor.figures.Figure;

public class CircleCreationTool extends AbstractCreationTool {

	public CircleCreationTool(Editor e) {
		super(e);
	}

	@Override
	protected Figure createFigure(BoundingBox boundingBox2) {
		return new Circle(boundingBox2);
	}

	@Override
	public String toString() {
		return "Herramienta de creación de círculo";
	}

}
