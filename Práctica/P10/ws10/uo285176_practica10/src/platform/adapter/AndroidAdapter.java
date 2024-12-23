/**
 * 
 */
package platform.adapter;

import java.awt.Point;

import platform.Api;
import platform.Image2D;
import platform.android.AndroidAPI;

/**
 * @author UO285176
 *
 */
public class AndroidAdapter implements Api {

	private AndroidAPI a = new AndroidAPI();

	@Override
	public Image2D load(String name) {
		return a.loadResource(name);
	}

	@Override
	public void paint(int x, int y, Image2D image) {
		a.draw(x, y, image);
	}

	@Override
	public Point getTouch() {
		return a.getTouch();
	}

}
