package editor.core;

public class BoundingBox {

	private int initialX, initialY;
	private int x1, y1, x2, y2;

	public BoundingBox(int x, int y) {
		initialX = x;
		initialY = y;
	}

	public void resizeTo(int x, int y) {
		setDimension(initialX, initialY, x, y);
	}

	private void setDimension(int initialX2, int initialY2, int x, int y) {
		this.x1 = initialX2;
		this.y1 = initialY2;
		this.x2 = x;
		this.y2 = y;
	}

	public int getInitialX() {
		return initialX;
	}

	public int getInitialY() {
		return initialY;
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

	@Override
	public String toString() {
		return "BoundingBox [initialX=" + initialX + ", initialY=" + initialY + ", x1=" + x1 + ", y1=" + y1 + ", x2="
				+ x2 + ", y2=" + y2 + "]";
	}

	public int getWidth() {
		return x2 - x1;
	}

	public int getHeight() {
		return y2 - y1;
	}

}
