/**
 * 
 */
package game;

import java.awt.Point;

import platform.Image2D;
import platform.playstation.Playstation5API;

/**
 * 
 */
public class PlayStation5BallGame extends BallGame {

	private Playstation5API playstation = new Playstation5API();

	@Override
	protected Image2D loadImage(String file) {
		return playstation.loadGraphics(file);
	}

	@Override
	protected void drawBall(Image2D image, Point point) {
		playstation.render(point.x, point.y, image);
	}

	@Override
	protected Point getPosition() {
		return playstation.getJoystick();
	}

}
