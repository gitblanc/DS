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
public class PlayStation5Platform implements Platform {
	private Playstation5API playstationApi = new Playstation5API();

	@Override
	public Image2D loadImage(String path) {
		return playstationApi.loadGraphics(path);
	}

	@Override
	public Point getPosition() {
		return playstationApi.getJoystick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		playstationApi.render(point.x, point.y, image);
	}
}
