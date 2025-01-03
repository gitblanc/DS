package CH.ifa.draw.samples.nada;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import CH.ifa.draw.standard.AbstractFigure;

public class EjemploFigure extends AbstractFigure {

	private int x = 0;
	private int y = 0;
	private int origin;
	private int corner;

	public EjemploFigure() {
	}

	public EjemploFigure(Point origin, Point corner) {
		this.x = origin.x;
		this.y = origin.y;
		this.origin = corner.x - origin.y;
		this.corner = origin.x - corner.y;
	}

	public void draw(Graphics g) {
		g.setColor(java.awt.Color.WHITE);
		g.fillRect(x, y, x, y);
	}

	public Rectangle displayBox() {
		return new Rectangle(0, 0, x, y);
	}

	public Vector handles() {
		return new Vector();
	}

	@Override
	protected void basicMoveBy(int dx, int dy) {// no invocar al draw
		this.x = dx;
		this.y = dy;
	}

	@Override
	public void basicDisplayBox(Point origin, Point corner) {// puntos inicio y fin
		x += origin.x;
		y += corner.y;
	}

}
