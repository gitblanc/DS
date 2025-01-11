package game;

import java.awt.Point;

import platform.Image2D;

public interface Platform {

	Image2D loadImage(String file);

	void drawBall(Image2D image, Point point);

	Point getPosition();

}
