package platform.adapters;

import java.awt.Point;

import platform.Image2D;
import platform.Platform;
import platform.playstation.Playstation5API;

public class PlayStationAPIPlatform implements Platform {

	private Playstation5API ps5 = new Playstation5API();

	@Override
	public Image2D loadImage(String file) {
		return ps5.loadGraphics(file);
	}

	@Override
	public Point getPosition() {
		return ps5.getJoystick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		ps5.render(point.x, point.y, image);
	}

}
