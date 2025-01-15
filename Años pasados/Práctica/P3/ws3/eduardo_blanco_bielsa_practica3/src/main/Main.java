package main;


import console.UserInterface;
import java.io.*;
import editor.*;

public class Main 
{
	private Editor editor;
	private UserInterface console;
	
	public static void main(String[] args) throws IOException
	{
		new Main().run();
	}
	
	public void run() throws IOException
	{
		editor = new Editor(new Drawing());
		console = new UserInterface(editor);
		
		console.showHelp();
		while(true)
			console.askUser();
	}
}
