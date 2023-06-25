package editor.core;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import editor.figures.Figure;

public class Drawing {
	private List<Figure> figures = new ArrayList<>();
	private Figure currentSelection;

	public void draw(PrintWriter output) {
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

	public Figure findFigureAt(int x, int y) {
		for (Figure f : figures) {
			if (f.contains(x, y))
				return f;
		}
		return null;
	}

	public void setCurrentSelection(Figure selectedFigure) {
		if (!figures.contains(selectedFigure))
			throw new IllegalArgumentException("La figura seleccionada no existe");
		this.currentSelection = selectedFigure;
	}

	public void clearCurrentSelection() {
		currentSelection = null;
	}

	public void addFigure(Figure newFigure) {
		if (newFigure != null)
			figures.add(newFigure);
		clearCurrentSelection();
		setCurrentSelection(newFigure);
	}

	public void removeFigure(Figure figure) {
		if (figure == null)
			throw new IllegalArgumentException("¡No se puede borrar una figura nula!");
		if (!figures.contains(figure))
			throw new IllegalArgumentException(
					"El documento no contiene dicha figura, no se ha podido borrar: " + figure);
		figures.remove(figure);
	}
}
