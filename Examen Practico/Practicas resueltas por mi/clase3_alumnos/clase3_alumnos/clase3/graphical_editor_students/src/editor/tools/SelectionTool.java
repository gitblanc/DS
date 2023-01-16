/**
 * 
 */
package editor.tools;

import editor.core.Editor;
import editor.core.Figure;
import editor.core.Tool;

/**
 * @author omenp
 */
public class SelectionTool implements Tool {

	private Editor editor;
	private int x, y;
	private Figure selectedFigure;

	public SelectionTool(Editor editor) {
		if (editor == null)
			throw new IllegalArgumentException("La herramienta de selección necesita una referencia al editor");
		this.editor = editor;
	}

	@Override
	public void clickOn(int x, int y) {
		if (selectedFigure != null) {
			editor.getDrawing().setCurrentSelection(selectedFigure);
		} else {
			editor.getDrawing().clearCurrentSelection();
		}
	}

	private void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveTo(int x, int y) {
		if (selectedFigure == null) {
			return;
		}
		selectedFigure.moveBy(x - this.x, y - this.y);
		setPosition(x, y);
	}

	@Override
	public void release() {
		selectedFigure = null;
	}

	@Override
	public void unselect() {
		selectedFigure = null;
	}
	
	@Override
	public String toString()
	{
		return "Herramienta de selección";
	}

}
