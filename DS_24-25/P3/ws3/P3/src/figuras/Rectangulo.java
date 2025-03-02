package figuras;

import editor.core.Lienzo;

public class Rectangulo implements Figura {

	private int x, y;
	private int width, height;

	public Rectangulo(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Rectangulo(Lienzo l) {
		this(l.getX(), l.getY(), l.getWidth(), l.getHeight());
	}

	@Override
	public void dibujar() {
		System.out.println("Rectángulo: (" + x + ", " + y + "), ancho = " + width + ", alto = " + height);
	}

	@Override
	public boolean contiene(int x, int y) {
		return this.x <= x && x <= this.x + width && this.y <= y && y <= this.y + height;
	}

	@Override
	public void mover(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	@Override
	public String toString() {
		return String.format("Rectángulo: (%d, %d), ancho = %d, alto = %d", x, y, width, height);
	}

}
