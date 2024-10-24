package tools;

import editor.core.EditorWindow;
import figuras.Figura;

public class HerramientaSeleccion implements Herramienta {

	private EditorWindow editor;
	private int x, y;
	private Figura figuraSeleccionada;

	public HerramientaSeleccion(EditorWindow editor) {
		this.editor = editor;
	}

	@Override
	public void pinchar(int x, int y) {
		figuraSeleccionada = editor.getDibujo().buscarFigura(x, y);
		if (figuraSeleccionada != null) {
			editor.getDibujo().seleccionarFiguraActual(figuraSeleccionada);
		} else {
			editor.getDibujo().limpiarSeleccion();
		}
		setPosition(x, y);
	}

	@Override
	public void mover(int x, int y) {
		if (figuraSeleccionada == null)
			return;
		figuraSeleccionada.mover(x - this.x, y - this.y);
		setPosition(x, y);

	}

	@Override
	public void soltar(int x, int y) {
		figuraSeleccionada = null;
	}

	private void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "HerramientaSeleccion [editor=" + editor + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public void unselect() {
		this.figuraSeleccionada = null;
	}

}
