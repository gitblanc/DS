/**
 * 
 */
package game;

import java.awt.Point;

import platform.Image2D;
import platform.android.AndroidAPI;

/**
 * 
 */
public class AndroidBallGame extends BallGame {
	
	private AndroidAPI android = new AndroidAPI();

	@Override
	protected Image2D loadImage(String file) {
		return android.loadResource(file);
	}

	@Override
	protected void drawBall(Image2D image, Point point) {
		android.draw(point.x, point.y, image);
	}

	@Override
	protected Point getPosition() {
		return android.getTouch();
	}

}
