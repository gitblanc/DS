/**
 * 
 */
package platform;

import java.awt.Point;

/**
 * @author omenp
 *
 */
public interface Platform {

	Image2D loadImage(String file);

	Point getPosition();

	void drawBall(Image2D image, Point point);
}
