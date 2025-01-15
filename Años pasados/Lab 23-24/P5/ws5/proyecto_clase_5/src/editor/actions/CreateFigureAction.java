/**
 * 
 */
package editor.actions;

import editor.core.Dibujo;
import editor.core.Figura;

/**
 * @author blanc
 *
 */
public class CreateFigureAction implements Action {
	
	private Figura figura;
	private Dibujo dibujo;
	
	public CreateFigureAction(Figura f, Dibujo d) {
		this.figura = f;
		this.dibujo = d;
	}

	@Override
	public void execute() {
		dibujo.addFigura(figura);
	}

	@Override
	public void undo() {
		dibujo.removeFigura(figura);
	}

}
