package CH.ifa.draw.samples.nada;

import java.awt.*;
import java.util.*;
import CH.ifa.draw.standard.*;

public class EjemploFigure extends AbstractFigure {
	private Rectangle area;

	protected void basicMoveBy(int dx, int dy) {
		area.translate(dx, dy);
	}

	public void basicDisplayBox(Point origin, Point corner) {
		area = new Rectangle(origin);
		area.add(corner);
	}

	public Rectangle displayBox() {
		return new Rectangle(area);
	}

	public Vector handles() {
		return new Vector();
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(area.x, area.y, area.width, area.height);
	}
}
