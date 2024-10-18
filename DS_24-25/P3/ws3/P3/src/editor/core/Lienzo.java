package editor.core;

public class Lienzo {
	private int inicialX, inicialY;
	private int x1, y1; // esquina superior izquierda
	private int x2, y2; // esquina inferior derecha

	public Lienzo(int x, int y) {
		this.inicialX = x1 = x2 = x;
		this.inicialY = y1 = y2 = y;
	}

	public Lienzo(int x1, int y1, int x2, int y2) {
		setDimension(x1, y1, x2, y2);
	}

	public void resizeTo(int x, int y) {
		setDimension(inicialX, inicialY, x, y);
	}

	private void setDimension(int x1, int y1, int x2, int y2) {
		this.x1 = (x1 <= x2) ? x1 : x2;
		this.x2 = (x2 >= x1) ? x2 : x1;
		this.y1 = (y1 <= y2) ? y1 : y2;
		this.y2 = (y2 >= y1) ? y2 : y1;
	}

	public int getX() {
		return x1;
	}

	public int getY() {
		return y1;
	}

	public int getWidth() {
		return x2 - x1;
	}

	public int getHeight() {
		return y2 - y1;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d), (%d, %d)", x1, y1, x2, y2);
	}
}
