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
	private WindowsAPI windowsApi = new WindowsAPI();

	@Override
	public Image2D loadImage(String path) {
		return windowsApi.loadFile(path);
	}

	@Override
	public Point getPosition() {
		return windowsApi.getMouseClick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		windowsApi.paint(point.x, point.y, image);
	}
}
