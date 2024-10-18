package editor.core;

import tools.*;

public class EditorWindow {

	private Dibujo dibujo;

	private HerramientaSeleccion herramientaSeleccion;
	private Herramienta herramientaActual;

	public EditorWindow() {
		dibujo = new Dibujo();
		herramientaActual = herramientaSeleccion = new HerramientaSeleccion(this);
	}

	public void dibuja() {

		// Se dibuja el menú
		// Se dibuja la barra de herramientas lateral
		// Se dibuja la línea de estado
		System.out.println("Herramienta actual:" + herramientaActual.toString());
		dibujo.dibuja();
	}

	// $ Métodos del Interfaz de Usuario -----------------------------

	public void mousePressed(int x, int y) {
		System.out.println("Herramienta actual en el pulsar:" + herramientaActual);
		this.herramientaActual.pinchar(x, y);
	}

	public void mouseMoved(int x, int y) {
		System.out.println("Herramienta actual en el mover:" + herramientaActual);
		this.herramientaActual.mover(x, y);
	}

	public void mouseReleased(int x, int y) {
		System.out.println("Herramienta actual en el soltar:" + herramientaActual);
		this.herramientaActual.soltar(x, y);
	}

	// $ Métodos del dibujo -----------------------------

	public Dibujo getDibujo() {
		return dibujo;
	}

	public Herramienta getDefaultHerramienta() {
		return herramientaSeleccion;
	}

	public Herramienta getHerramientaActual() {
		return this.herramientaActual;
	}

	public void setHerramientaActual(Herramienta herramienta) {
		this.herramientaActual.unselect();
		this.herramientaActual = herramienta;
		System.out.println("Herramienta actual en el set:" + herramientaActual);
	}

	public void herramientaTerminada() {
		setHerramientaActual(herramientaSeleccion);
	}

}
