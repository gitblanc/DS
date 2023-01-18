package main;

import game.BallGame;
import platform.adapters.WindowsAdapter;

public class Main 
{
	public static void main(String[] args) 
	{
		BallGame game = new BallGame(new WindowsAdapter());
		game.play();
	}
}
