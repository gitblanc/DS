package game;

import java.awt.Point;

import platform.Image2D;

/* Esta clase/paquete sería el código del videojuego, el cual se quiere reutilizar
 * en las distintas plataformas
 */

public class BallGame {
	// Seleccionar para qué plataforma se quiere generar el juego
	private Platform platform;

	public BallGame(Platform p) {
		this.platform = p;
	}

	public void start() {

		Image2D image = loadImage("Bola.jpg");

		// Lógica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = getPosition();
			// Comprobar colisiones...
			// Imprimir marcador...
			// Otra lógica del juego...
			drawBall(image, point);
		}
	}

	private Image2D loadImage(String file) {

		return platform.loadImage(file);
	}

	private void drawBall(Image2D image, Point point) {
		platform.drawBall(image, point);
	}

	private Point getPosition() {
		return platform.getPosition();
	}
}
