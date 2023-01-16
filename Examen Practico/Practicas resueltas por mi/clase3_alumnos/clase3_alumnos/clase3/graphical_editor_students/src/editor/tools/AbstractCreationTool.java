/**
 * 
 */
package editor.tools;

import editor.core.BoundingBox;
import editor.core.Editor;
import editor.core.Figure;
import editor.core.Tool;

/**
 * @author omenp
 *
 */
public abstract class AbstractCreationTool implements Tool{
	private Editor editor;
	private BoundingBox boundingBox;
	
	protected AbstractCreationTool(Editor editor)
	{
		if (editor == null)
			throw new IllegalArgumentException("Las herramientas de creación necesitan una referencia (no nula) al editor");
		this.editor = editor;		
	}
	
	@Override
	public void clickOn(int x, int y) 
	{
		editor.getDrawing().clearCurrentSelection();
		boundingBox = new BoundingBox(x, y);
	}

	@Override
	public void moveTo(int x, int y) 
	{
 		if (boundingBox == null) {
			return;
		}
		boundingBox.resizeTo(x, y);
	}

	@Override
	public void release() 
	{
		if (boundingBox == null) {
			return;
		}
		Figure newFigure = createFigure(boundingBox);
		editor.getDrawing().addFigure(newFigure);		
		editor.toolDone();
		// Al soltar se elimina el área de selección actual
		boundingBox = null;
	}
	
	protected abstract Figure createFigure(BoundingBox boundingBox);
	
	@Override
	public void unselect()
	{
		boundingBox = null;		
	}
	
	@Override
	public String toString()
	{
		return "Herramienta de creación abstracta";
	}
}
