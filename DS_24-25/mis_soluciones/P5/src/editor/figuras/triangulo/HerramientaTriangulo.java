/**
 * 
 */
package editor.figuras.triangulo;

import java.awt.Point;

import editor.core.EditorWindow;
import editor.core.Figura;
import editor.core.Herramienta;

/**
 * 
 */
public class HerramientaTriangulo implements Herramienta {

	private int vertices = 0;
	private Point[] vertice = new Point[3];
	private EditorWindow editor;

	public HerramientaTriangulo(EditorWindow editor) {
		this.editor = editor;
	}

	public void mousePressed(int x, int y) {
		vertice[vertices++] = new Point(x, y);
		if (vertices == 3) {
			Figura figura = new Triangulo(vertice[0], vertice[1], vertice[2]);
			editor.getDibujo().addFigura(figura);
			vertices = 0;
			editor.finHerramienta();
		}
	}

	public void mouseMoved(int x, int y) {
	}

	public void mouseReleased(int x, int y) {
	}

}
