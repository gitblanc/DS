/**
 * 
 */
package editor.figuras.rectangulo;

import java.awt.Point;

import editor.core.Figura;

/**
 * 
 */
public class Rectangulo implements Figura {

	private Point esquina;
	private int ancho, alto;

	public Rectangulo(Point posicionInicio, int ancho, int alto) {
		this.esquina = posicionInicio;
		this.ancho = ancho;
		this.alto = alto;
	}

	public Rectangulo(Point posicionInicio, Point posFin) {
		this(posicionInicio, posFin.x - posicionInicio.x, posFin.y - posicionInicio.y);
	}

	@Override
	public void dibujar() {
		System.out.println(
				"  - Rectangulo: x = " + esquina.x + ", y = " + esquina.y + ", ancho = " + ancho + ", alto = " + alto);
	}

	@Override
	public boolean contiene(int x, int y) {
		return (esquina.x <= x && x <= esquina.x + ancho) && (esquina.y <= y && y <= esquina.y + alto);
	}

	@Override
	public void mover(int i, int j) {
		esquina.translate(i, j);
	}

}
