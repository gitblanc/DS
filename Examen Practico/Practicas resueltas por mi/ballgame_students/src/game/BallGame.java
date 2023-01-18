package game;

import java.awt.Point;

import platform.Image2D;
import platform.Platform;

/* Esta clase (y todo el código que hubiera dentro de este paquete) sería el
 * código del videojuego completo, y es lo que se desea reutilizar en las distintas
 * plataformas.
 */

public class BallGame {

	private Platform platform;

	public BallGame(Platform platform) {
		this.platform = platform;
	}

	public void play() {
		Image2D image = loadImage("ball.png");

		// lógica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = getPosition();
			drawBall(image, point);
		}
	}

	private Image2D loadImage(String file) {
		return platform.loadImage(file);
	}

	private Point getPosition() {
		return platform.getPosition();
	}

	private void drawBall(Image2D image, Point point) {
		platform.drawBall(image, point);
	}
}
