package platform;

import java.awt.Point;

public interface Platform {
	Image2D loadImage(String file);

	Point getPosition();

	void drawBall(Image2D image, Point point);
}
