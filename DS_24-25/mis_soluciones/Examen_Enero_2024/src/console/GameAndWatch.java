package console;

import java.util.List;

import console.games.F1GrandPrix;
import console.games.MortalMaze;
import console.games.SpaceInvaders;

public class GameAndWatch {

	EstadoConsola screen;
	private EstadoConsola menu = new Menu(this);
	boolean exit;
	private List<EstadoConsola> games;
	private int selectedGame;

	public GameAndWatch() {

		// $ Inicialización del menu -----------------------------
		this.games = List.of(new MortalMaze(this), new F1GrandPrix(this), new SpaceInvaders(this));
		selectedGame = 0;

		this.screen = menu;
	}

	// # ------------------------------------------------------------------
	// # Botones de la consola

	public void upPressed() {
		this.screen.upPressed();
	}

	public void downPressed() {
		this.screen.downPressed();
	}

	public void leftPressed() {
		this.screen.leftPressed();
	}

	public void rightPressed() {
		this.screen.rightPressed();
	}

	public void backPressed() {
		this.screen.backPressed();
	}

	// # ------------------------------------------------------------------
	// # Otros métodos de la consola

	public boolean exit() {
		return exit;
	}

	public void draw() {
		this.screen.draw();
	}

	public void gameFinished() {
		draw();
		setScreen(menu);
	}

	public void setScreen(EstadoConsola screen) {
		this.screen = screen;
		restart();
	}

	void restart() {
		this.screen.restart();
	}

	public int getSelectedGame() {
		return this.selectedGame;
	}

	public void setSelectedGame(int selectedGame2) {
		this.selectedGame = selectedGame2;
	}

	public List<EstadoConsola> getGames() {
		return this.games;
	}

	public void setExit(boolean b) {
		this.exit = b;
	}

	public EstadoConsola getMenu() {
		return this.menu;
	}
}
