/**
 * 
 */
package platform.adapter;

import java.awt.Point;

import platform.Api;
import platform.Image2D;
import platform.playstation.Playstation5API;

/**
 * @author UO285176
 *
 */
public class PlayStationAdapter implements Api {

	private Playstation5API p5 = new Playstation5API();

	@Override
	public Image2D load(String name) {
		return p5.loadGraphics(name);
	}

	@Override
	public void paint(int x, int y, Image2D image) {
		p5.render(x, y, image);
	}

	@Override
	public Point getTouch() {
		return p5.getJoystick();
	}

}
