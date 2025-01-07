package editor.core;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {

	private List<Figura> figuras = new ArrayList<Figura>();

	public void dibuja() {
		// Dibujar las figuras que contenga
		for (Figura f : figuras)
			f.dibujar();
	}

	public void addFigura(Figura f) {
		figuras.add(f);
	}

	public void removeFigura(Figura f) {
		figuras.remove(f);
	}

	public Figura getFigura(int x, int y) {
		for (Figura f : figuras) {
			if (f.contiene(x, y))
				return f;
		}
		return null;
	}
}
