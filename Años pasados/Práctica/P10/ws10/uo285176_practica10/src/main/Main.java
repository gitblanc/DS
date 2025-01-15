package main;

import game.BallGame;
import platform.Api;
import platform.adapter.PlayStationAdapter;

public class Main {
	public static void main(String[] args) {
		Api a = new PlayStationAdapter();// se pasa directamente la api que queremos usar
		BallGame game = new BallGame(a);
		game.play();
	}
}
