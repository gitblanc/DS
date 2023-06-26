package game;

import java.awt.Point;

import platform.Image2D;
import platform.Platform;

/* Esta clase (y todo el código que hubiera dentro de este paquete) sería el
 * código del videojuego completo, y es lo que se desea reutilizar en las distintas
 * plataformas.
 */


public class BallGame 
{
	// Decide para qué plataform queremos generar el juego
	private Platform platform;

	public BallGame(Platform p) {
		this.platform = p;
	}

	public void play() 
	{
		Image2D image = platform.loadImage("ball.png");

		// lógica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = platform.getPosition();
			platform.drawBall(image, point);
		}
	}

//	private void setAPI() 
//	{
//		if (platform == Platform.ANDROID)
//			android = new AndroidAPI();
//		else if (platform == Platform.WINDOWS)
//			windows = new WindowsAPI();
//		else
//			playstation = new Playstation5API();
//	}
//
//	private Image2D loadImage(String file) 
//	{
//		Image2D image;
//		if (platform == Platform.ANDROID)
//			image = android.loadResource(file);
//		else if (platform == Platform.WINDOWS)
//			image = windows.loadFile(file);
//		else
//			image = playstation.loadGraphics(file);
//		return image;
//	}
//
//	private Point getPosition() 
//	{
//		Point point;
//		if (platform == Platform.ANDROID)
//			point = android.getTouch();
//		else if (platform == Platform.WINDOWS)
//			point = windows.getMouseClick();
//		else
//			point = playstation.getJoystick();
//		return point;
//	}
//
//	private void drawBall(Image2D image, Point point) 
//	{
//		if (platform == Platform.ANDROID)
//			android.draw(point.x, point.y, image);
//		else if (platform == Platform.WINDOWS)
//			windows.paint(point.x, point.y, image);
//		else
//			playstation.render(point.x, point.y, image);
//	}
}
