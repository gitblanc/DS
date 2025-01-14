/**
 * 
 */
package console;

/**
 * 
 */
public class Menu implements EstadoConsola {

	private GameAndWatch game;

	public Menu(GameAndWatch game) {
		this.game = game;
	}

	@Override
	public void upPressed() {
		if (game.getSelectedGame() > 0)
			game.setSelectedGame(game.getSelectedGame() - 1);
	}

	@Override
	public void downPressed() {
		if (game.getSelectedGame() < game.getGames().size() - 1)
			game.setSelectedGame(game.getSelectedGame() + 1);
	}

	@Override
	public void leftPressed() {
	}

	@Override
	public void rightPressed() {
		game.setScreen(game.getGames().get(game.getSelectedGame()));
	}

	@Override
	public void backPressed() {
		game.setExit(true);
	}

	@Override
	public void draw() {
		drawMenu();
	}

	@Override
	public void restart() {
	}

	// # ------------------------------------------------------------------
	// # Métodos del Menú

	public void drawMenu() {
		System.out.println("\n--------------------");
		System.out.println("Select a game: (W/S -> up/down. D -> play game)");
		for (int i = 0; i < this.game.getGames().size(); i++) {
			System.out.print((i == this.game.getSelectedGame()) ? " >> " : "    ");
			System.out.println(this.game.getGames().get(i).toString());
		}
		System.out.println("(C -> turn off)");
	}
}
