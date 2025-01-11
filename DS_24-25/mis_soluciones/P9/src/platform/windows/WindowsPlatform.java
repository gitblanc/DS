/**
 * 
 */
package platform.windows;

import java.awt.Point;

import game.Platform;
import platform.Image2D;

/**
 * 
 */
public class WindowsPlatform implements Platform {

	private WindowsAPI windows = new WindowsAPI();

	@Override
	public Image2D loadImage(String file) {
		return windows.loadFile(file);
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		windows.paint(point.x, point.y, image);
	}

	@Override
	public Point getPosition() {
		return windows.getMouseClick();
	}

}
