package editor.core;

import java.util.ArrayList;
import java.util.List;

import figuras.Figura;

public class Dibujo {

	private List<Figura> figuras = new ArrayList<>();
	private Figura seleccionActual;

	public void addFigura(Figura fig) {
		figuras.add(0, fig);
		limpiarSeleccion();
		seleccionarFiguraActual(fig);
	}

	public void eliminarFigura(Figura f) {
		if (figuras.contains(f))
			figuras.remove(f);
		throw new IllegalArgumentException("La figura no existe");
	}

	public void dibuja() {
		System.out.println("Figuras:\n");
		// Dibujar las figuras que contenga
		if (figuras.isEmpty())
			return;
		for (Figura f : figuras) {
			System.out.print(" - ");
			f.dibujar();
			System.out.println();
		}
	}

	public Figura buscarFigura(int x, int y) {
		for (Figura f : figuras) {
			if (f.contiene(x, y))
				return f;
		}
		return null;
	}

	public void limpiarSeleccion() {
		this.seleccionActual = null;
	}

	public void seleccionarFiguraActual(Figura f) {
		this.seleccionActual = f;
	}

	public Figura getFiguraActual() {
		return this.seleccionActual;
	}
}