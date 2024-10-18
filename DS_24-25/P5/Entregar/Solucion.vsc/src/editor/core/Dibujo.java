package editor.core;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {

	private List<Figura> figuras = new ArrayList<>();

	public void addFigura(Figura figura) {
		figuras.add(figura);
	}

	public void removeFigura(Figura figura) {
		figuras.remove(figura);
	}

	public void dibuja() {
		for (Figura figura : figuras) {
			figura.dibujar();
		}
	}

	public Figura getFigura(int x, int y) {
		for (Figura figura : figuras)
			if (figura.contiene(x, y))
				return figura;
		return null;
	}

}
