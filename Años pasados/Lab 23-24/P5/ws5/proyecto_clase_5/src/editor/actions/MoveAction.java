/**
 * 
 */
package editor.actions;

import editor.core.Figura;

/**
 * @author blanc
 *
 */
public class MoveAction implements Action {
	
	private Figura figura;
	private int x,y;
	
	public MoveAction(Figura f, int x, int y) {
		if(f == null)
			throw new IllegalArgumentException("¡Se necesita la figura que ha sido movida!");
		
		this.figura = f;
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute() {
		figura.mover(x, y);
	}

	@Override
	public void undo() {
		figura.mover(-x, -y);
	}

}
