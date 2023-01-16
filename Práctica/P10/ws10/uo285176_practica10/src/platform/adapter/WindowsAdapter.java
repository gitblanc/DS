package platform.adapter;

import java.awt.Point;

import platform.Api;
import platform.Image2D;
import platform.windows.WindowsAPI;

public class WindowsAdapter implements Api{
	
	private WindowsAPI windows = new WindowsAPI();
	
	@Override
	public Image2D load(String name) {
		return windows.loadFile(name);
	}

	@Override
	public void paint(int x, int y, Image2D image) {
		windows.paint(x, y, image);
	}

	@Override
	public Point getTouch() {
		return windows.getMouseClick();
	}

}
