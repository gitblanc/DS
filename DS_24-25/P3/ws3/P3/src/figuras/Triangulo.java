package figuras;

import editor.core.Lienzo;

public class Triangulo implements Figura {

	// las coordenadas de los vertices
	private int x1, y1, x2, y2, x3, y3;

	public Triangulo(Lienzo l) {
		// // vértice superior
		x1 = l.getX() + (l.getWidth() / 2);
		y1 = l.getY();
		// vértice inferior izquierdo
		x2 = l.getX();
		y2 = l.getY() + l.getHeight();
		// vértice inferior derecho
		x3 = l.getX() + l.getWidth();
		y3 = l.getY() + l.getHeight();
	}

	public Triangulo(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	@Override
	public void dibujar() {
		System.out.println("Triángulo: (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")");
	}

	@Override
	public boolean contiene(int x, int y) {
		return (x == x1 && y == y1) || (x == x2 && y == y2) || (x == x3 && y == y3);
	}

	@Override
	public void mover(int dx, int dy) {
		x1 += dx;
		y1 += dy;
		x2 += dx;
		y2 += dy;
		x3 += dx;
		y3 += dy;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public int getX3() {
		return x3;
	}

	public int getY3() {
		return y3;
	}

	@Override
	public String toString() {
		return String.format("Triángulo: (%d, %d), (%d, %d), (%d, %d)", x1, y1, x2, y2, x3, y3);
	}

}
