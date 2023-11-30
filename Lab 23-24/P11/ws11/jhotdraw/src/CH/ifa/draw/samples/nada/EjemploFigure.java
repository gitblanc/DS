package CH.ifa.draw.samples.nada;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import CH.ifa.draw.standard.AbstractFigure;

public class EjemploFigure extends AbstractFigure {

	int x1, y1, x2, y2;

//	public EjemploFigure(Point origin, Point corner) {
//		basicDisplayBox(origin, corner);
//	}
	
	public EjemploFigure() {
		
	}

	public void draw(Graphics g) {
		g.setColor(java.awt.Color.BLUE);
		g.fillRect(x1, y1, x2, y2);
	}

	public Rectangle displayBox() {
		return new Rectangle(x1, y1, x2, y2);
	}

	public Vector handles() {
		return new Vector();
	}

	@Override
	protected void basicMoveBy(int dx, int dy) {
		this.x1 += dx;
		this.y1 += dy;
	}

	@Override
	public void basicDisplayBox(Point origin, Point corner) {
		this.x1 = origin.x;
		this.y1 = origin.y;
		this.x2 = corner.x - origin.x;
		this.y2 = corner.y - corner.y;
	}
}
