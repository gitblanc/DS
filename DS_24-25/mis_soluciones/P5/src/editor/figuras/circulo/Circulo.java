/**
 * 
 */
package editor.figuras.circulo;

import java.awt.Point;

import editor.core.Figura;

/**
 * 
 */
public class Circulo implements Figura {

	private Point centro;
	private int radio;

	public Circulo(Point centro, int radio) {
		this.centro = centro;
		this.radio = radio;
	}

	@Override
	public void dibujar() {
		System.out.println("  - Círculo: centro = " + centro + ", radio = " + radio);
	}

	@Override
	public boolean contiene(int x, int y) {
		double distancia = Math.sqrt(Math.pow(x - centro.x, 2) + Math.pow(y - centro.y, 2));
		return distancia < radio;
	}

	@Override
	public void mover(int i, int j) {
		centro.translate(i, j);
	}

}
