package figuras;

import editor.core.Lienzo;

public class Circulo implements Figura {

	private int x, y; // coordenadas del centro
	private int radio;

	public Circulo(int x, int y, int radio) {
		this.x = x;
		this.y = y;
		this.radio = radio;
	}

	public Circulo(Lienzo lienzo) {
		int size = Math.max(lienzo.getWidth(), lienzo.getHeight());
		this.x = lienzo.getX() + (size / 2);
		this.y = lienzo.getY() + (size / 2);
		this.radio = size / 2;
	}

	@Override
	public void dibujar() {
		System.out.println("Círculo: (" + x + ", " + y + "), radio = " + radio);
	}

	@Override
	public boolean contiene(int x, int y) {
		double distance = Math.sqrt(Math.pow(x - getX(), 2) + Math.pow(y - getY(), 2));
		return distance < getRadio();
	}

	@Override
	public void mover(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadio() {
		return radio;
	}

	@Override
	public String toString() {
		return String.format("Círculo: centro = (%d, %d), radio = %d", x, y, radio);
	}

}