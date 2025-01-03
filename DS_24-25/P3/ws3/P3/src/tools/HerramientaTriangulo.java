package tools;

import editor.core.EditorWindow;
import figuras.Triangulo;

public class HerramientaTriangulo implements Herramienta {

	private EditorWindow editor;
	private int x1, y1, x2, y2, x3, y3; // las coordenadas de los vertices
	private int vertices; // puntos creados

	public HerramientaTriangulo(EditorWindow editor) {
		if (editor == null)
			throw new IllegalArgumentException("Se necesita una referencia al editor");
		this.editor = editor;
	}

	@Override
	public void pinchar(int x, int y) {
		vertices++;
		if (vertices == 1) {
			editor.getDibujo().limpiarSeleccion();
			x1 = x;
			y1 = y;
		} else if (vertices == 2) {
			x2 = x;
			y2 = y;
		} else if (vertices == 3) {
			x3 = x;
			y3 = y;
			editor.getDibujo().addFigura(new Triangulo(x1, y1, x2, y2, x3, y3));
			vertices = 0;
			editor.herramientaTerminada();
		}
	}

	@Override
	public void mover(int x, int y) {

	}

	@Override
	public void soltar(int x, int y) {

	}

	@Override
	public String toString() {
		return "Herramienta de creación de triángulo";
	}

	@Override
	public void unselect() {
		vertices = 0;
	}

}
