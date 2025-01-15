package editor.core;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Drawing 
{
	private List<Figure> figures = new ArrayList<>();
	private Figure currentSelection;
	
	public void draw(PrintWriter output)
	{
		if (figures.isEmpty())
			return;
		output.println("Figuras: ");
		for (Figure figure : figures) {
			output.print(" - ");
			figure.draw(output);
			if (figure == currentSelection)
				output.print(" (*)");
			output.println();
		}
	}

	public void setCurrentSelection(Figure figure)
	{
		if (!figures.contains(figure))
			throw new IllegalArgumentException("¡No se puede seleccionar una figura que no existe en el documento!: " + figure);
		currentSelection = figure;
	}
	
	public Figure getCurrentSelection()
	{
		return currentSelection;
	}
	
	public void clearCurrentSelection()
	{
		currentSelection = null;
	}
	
	public void addFigure(Figure figure)
	{
		if (figure == null)
			throw new IllegalArgumentException("¡No se puede añadir una figura nula!");
		figures.add(0, figure);
		clearCurrentSelection();
		setCurrentSelection(figure);
	}
	
	public void removeFigure(Figure figure)
	{
		if (figure == null)
			throw new IllegalArgumentException("¡No se puede borrar una figura nula!");
		if (!figures.contains(figure))
			throw new IllegalArgumentException("El documento no contiene dicha figura, no se ha podido borrar: " + figure);
		figures.remove(figure);
	}
	
	public Figure findFigureAt(int x, int y)
	{
		for (Figure figure : figures) {
			if (figure.contains(x, y))
				return figure;
		}
		return null;
	}
}
