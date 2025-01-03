package main;
import java.io.*;

import editor.*;
import editor.core.Drawing;
import editor.core.Editor;
import editor.figures.CircleCreationTool;
import editor.figures.RectangleCreationTool;
import editor.figures.TriangleCreationTool;
import editor.ui.Menu;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		Editor editor = new Editor();
		Menu menu = new Menu(editor);
		
		//-- Se registran las distintas herramientas
		menu.addTool("seleccion", editor.getDefaultTool());
		menu.addTool("rectangulo", new RectangleCreationTool(editor));
		menu.addTool("circulo", new CircleCreationTool(editor));
		menu.addTool("triangulo", new TriangleCreationTool(editor));
		
		menu.run();
	}
}
