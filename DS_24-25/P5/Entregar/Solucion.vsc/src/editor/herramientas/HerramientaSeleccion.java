package editor.herramientas;

import java.awt.Point;

import editor.cambios.MoverCambio;
import editor.core.*;

public class HerramientaSeleccion implements Herramienta {

	private EditorWindow editor;

	private Figura seleccionada;
	private Point posicionAnterior, posicionInicial;

	public HerramientaSeleccion(EditorWindow editor) {
		this.editor = editor;
	}

	public void mousePressed(int x, int y) {
		seleccionada = editor.getDibujo().getFigura(x, y);
		posicionAnterior = posicionInicial = new Point(x, y);
	}

	public void mouseMoved(int x, int y) {
		mueveIncremento(x, y);
	}

	public void mouseReleased(int x, int y) {
		mueveIncremento(x, y);

		if (this.seleccionada != null)
			this.editor.getHistorial().addCambio(new MoverCambio(this.seleccionada,
					posicionAnterior.x - posicionInicial.x, posicionAnterior.y - posicionInicial.y));
	}

	private void mueveIncremento(int x, int y) {
		if (seleccionada != null) {
			seleccionada.mover(x - posicionAnterior.x, y - posicionAnterior.y);
			posicionAnterior = new Point(x, y);
		}
	}

}
