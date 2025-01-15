package CH.ifa.draw.samples.nada;

import java.awt.*;
import java.util.Vector;

import CH.ifa.draw.standard.AbstractFigure;

public class EjemploFigure extends AbstractFigure {

	private int x, y, ancho, alto;

	public Rectangle displayBox() {
		return new Rectangle(x, y, ancho, alto);
	}

	public Vector handles() {
		return new Vector();
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, ancho, alto);
	}

	// Suponiendo siempre que se suelta por debajo y a la derecha
	@Override
	protected void basicMoveBy(int dx, int dy) {
		x += dx;
		y += dy;
	}

	@Override
    public void basicDisplayBox(Point origin, Point corner) {
        x = Math.min(origin.x, corner.x);
        y = Math.min(origin.y, corner.y);
        ancho = Math.abs(origin.x - corner.x);
        alto = Math.abs(origin.y - corner.y);
    }


}
