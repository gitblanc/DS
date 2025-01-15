/**
 * 
 */
package editor.figures;

import editor.core.BoundingBox;
import editor.core.Editor;
import editor.core.Figure;
import editor.tools.AbstractCreationTool;

/**
 * @author omenp
 *
 */
public class CircleCreationTool extends AbstractCreationTool{

	public CircleCreationTool(Editor editor) {
		super(editor);
	}

	@Override
	protected Figure createFigure(BoundingBox boundingBox) {
		return new Circle(boundingBox);
	}

	@Override
	public String toString() {
		return "Herramienta de creación de círculo";
	}
}
