/**
 * 
 */
package platform.playstation;

import java.awt.Point;

import game.Platform;
import platform.Image2D;

/**
 * 
 */
public class PlayStationPlatform implements Platform {

	private Playstation5API ps5 = new Playstation5API();

	@Override
	public Image2D loadImage(String file) {
		return ps5.loadGraphics(file);
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		ps5.render(point.x, point.y, image);
	}

	@Override
	public Point getPosition() {
		return ps5.getJoystick();
	}

}
