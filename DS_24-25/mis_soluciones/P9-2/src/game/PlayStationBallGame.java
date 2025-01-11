package game;

import java.awt.Point;

import platform.Image2D;
import platform.playstation.Playstation5API;

public class PlayStationBallGame extends BallGame {

	private Playstation5API ps5 = new Playstation5API();

	@Override
	protected Image2D loadImage(String file) {
		return ps5.loadGraphics(file);
	}

	@Override
	protected void drawBall(Image2D image, Point point) {
		ps5.render(point.x, point.y, image);
	}

	@Override
	protected Point getPosition() {
		return ps5.getJoystick();
	}

}
