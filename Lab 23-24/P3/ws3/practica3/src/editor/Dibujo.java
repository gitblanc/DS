package editor;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import figures.Figure;

public class Dibujo {

	private List<Figure> figures = new ArrayList<>();

	public void addFigura(Figure figure) {
		figures.add(figure);
	}

	public void removeFigura(Figure figure) {
		if (!figures.contains(figure))
			throw new IllegalArgumentException("La figura no existe");
		figures.remove(figure);
	}

	public void dibujar(PrintWriter output) {
		if (figures.isEmpty())
			return;
		output.println("Figuras: ");
		for (Figure figure : figures) {
			output.print(" - ");
			figure.draw(output);
			output.println();
		}
	}

	public Figure buscarFigura(int x, int y) {
		for (Figure figure : figures) {
			if (figure.contains(x, y))
				return figure;
		}
		return null;
	}

}
