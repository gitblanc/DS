package editor.cambios;

import editor.core.Dibujo;
import editor.core.Figura;

public class CreacionCambio implements Cambio {
	
	private Figura figura;
	private Dibujo dibujo;

	public CreacionCambio(Figura figura, Dibujo dibujo) {
		this.figura = figura;
		this.dibujo = dibujo;
	}

	@Override
	public void redo() {
		this.dibujo.addFigura(figura);
	}

	@Override
	public void undo() {
		this.dibujo.removeFigura(figura);
	}

}
