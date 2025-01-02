/**
 * 
 */
package platform.android;

import java.awt.Point;

import game.Platform;
import platform.Image2D;

/**
 * 
 */
public class AndroidPlatform implements Platform {
	private AndroidAPI androidApi = new AndroidAPI();

	@Override
	public Image2D loadImage(String path) {
		return androidApi.loadResource(path);
	}

	@Override
	public Point getPosition() {
		return androidApi.getTouch();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		androidApi.draw(point.x, point.y, image);
	}

}
