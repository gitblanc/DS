package editor.figures;

import java.io.PrintWriter;

import editor.core.BoundingBox;

public class Circle implements Figure {
	private int x, y;
	private int radious;

	public Circle(BoundingBox boundingBox2) {
		int size = Math.max(boundingBox2.getWidth(), boundingBox2.getHeight());
	}

	@Override
	public boolean contains(int x, int y) {
		double distance = Math.sqrt(Math.pow(x - getX(), 2) + Math.pow(y - getY(), 2));
		return distance < getRadious();
	}

	@Override
	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadious() {
		return radious;
	}

	@Override
	public void draw(PrintWriter output) {
		output.format("Círculo: (%d, %d), radio = %d", x, y, radious);
	}

}
