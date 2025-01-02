/**
 * 
 */
package game;

import java.awt.Point;

import platform.Image2D;
import platform.windows.WindowsAPI;

/**
 * 
 */
public class WindowsBallGame extends BallGame {

	private WindowsAPI windows = new WindowsAPI();

	@Override
	protected Image2D loadImage(String file) {
		return windows.loadFile(file);
	}

	@Override
	protected void drawBall(Image2D image, Point point) {
		windows.paint(point.x, point.y, image);
	}

	@Override
	protected Point getPosition() {
		return windows.getMouseClick();
	}

}
