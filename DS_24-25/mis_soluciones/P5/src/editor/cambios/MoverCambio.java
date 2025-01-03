package editor.cambios;

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
	public void redo() {
		figura.mover(x, y);
	}

	@Override
	public void undo() {
		figura.mover(-x, -y);
	}

}
