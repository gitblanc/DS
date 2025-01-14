/**
 * 
 */
package console.games;

import console.EstadoConsola;
import console.GameAndWatch;

/**
 * 
 */
public class MortalMaze implements EstadoConsola {
	// # ------------------------------------------------------------------
	// # Variables de Mortal Maze

	private static final int WIDTH = 14;
	private static final int HEIGHT = 7;

	private int playerX, playerY;
	private int exitX, exitY;

	private GameAndWatch game;

	public MortalMaze(GameAndWatch game) {
		this.game = game;
	}

	@Override
	public void upPressed() {
		if (playerY > 1) {
			playerY--;
			checkMazeFinished();
		}
	}

	@Override
	public void downPressed() {
		if (playerY < HEIGHT - 2) {
			playerY++;
			checkMazeFinished();
		}
	}

	@Override
	public void leftPressed() {
		if (playerX > 1) {
			playerX--;
			checkMazeFinished();
		}
	}

	@Override
	public void rightPressed() {
		if (playerX < WIDTH - 2) {
			playerX++;
			checkMazeFinished();
		}
	}

	@Override
	public void backPressed() {
		game.setScreen(game.getMenu());
	}

	@Override
	public void draw() {
		drawMaze();
	}

	@Override
	public void restart() {
		System.out.println("----------------------------");
		System.out.println("Mortal Maze!!!");
		System.out.println("(W/S -> up/down. A/D -> left/right)");
		System.out.println("(C -> menu)");

		initializeMaze();
	}
	
	@Override
	public String toString() {
		return "MortalMaze";
	}

	// # ------------------------------------------------------------------
	// # Métodos de Mortal Maze

	private void initializeMaze() {
		playerX = playerY = 2;
		exitX = exitY = 4;
	}

	private void checkMazeFinished() {
		if (playerX == exitX && playerY == exitY) {
			this.game.gameFinished();
			System.out.println("You won!");
		}
	}

	public void drawMaze() {
		var map = new char[HEIGHT][WIDTH];

		// Fill first and last column with '#'
		for (int i = 0; i < map[0].length; i++) {
			map[0][i] = '#';
			map[map.length - 1][i] = '#';
		}

		// Fill inside lines with a border around and spaces inside
		for (int i = 1; i < map.length - 1; i++) {
			map[i][0] = '#';
			map[i][map[i].length - 1] = '#';
			for (int j = 1; j < map[i].length - 1; j++)
				map[i][j] = ' ';
		}

		// Put exit and player
		map[exitY][exitX] = 'X';
		map[playerY][playerX] = 'O';

		// draw all
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}

		System.out.println();
	}
}
