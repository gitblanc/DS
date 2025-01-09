package editor.cambios;

import editor.core.Cambio;
import editor.core.Figura;

public class MoverCambio implements Cambio {

	private Figura figura;
	private int x, y;

	public MoverCambio(Figura seleccionada, int i, int j) {
		this.figura = seleccionada;
		this.x = i;
		this.y = j;
	}

	@Override
	public void undo() {
		this.figura.mover(y, x);
	}

	@Override
	public void redo() {
		this.figura.mover(-y, -x);
	}

}
