package editor.core;

import java.util.HashMap;
import java.util.Map;

import editor.figuras.circulo.HerramientaCirculo;
import editor.figuras.rectangulo.HerramientaRectangulo;
import editor.figuras.triangulo.HerramientaTriangulo;
import editor.herramientas.HerramientaSeleccion;

public class EditorWindow {

	private Dibujo dibujo;
	// Herramientas disponibles
	private Map<String, Herramienta> herramientas;
	// Herramienta seleccionada
	private Herramienta herramienta, seleccion;
	// Historial
	private HistorialCambios historial;

	public EditorWindow() {
		dibujo = new Dibujo();
		herramientas = new HashMap<String, Herramienta>();
		crearHerramientas();
		// En un principio la herramienta seleccionada es la de selección
		herramienta = seleccion = herramientas.get("seleccion");
		historial = new HistorialCambios();
	}

	private void crearHerramientas() {
		herramientas.put("rectangulo", new HerramientaRectangulo(this));
		herramientas.put("circulo", new HerramientaCirculo(this));
		herramientas.put("triangulo", new HerramientaTriangulo(this));
		herramientas.put("seleccion", new HerramientaSeleccion(this));
	}

	public void dibuja() {

		// Se dibuja el menú
		// Se dibuja la barra de herramientas lateral
		// Se dibuja la línea de estado

		dibujo.dibuja();
		System.out.println("  [" + herramienta.getClass().getSimpleName() + " activada]");
		System.out.println();
	}

	// $ Métodos del Interfaz de Usuario -----------------------------

	// Se pincha el botón de una herramienta para activarla
	public void toolButtonClicked(String toolName) {
		setHerramienta(herramientas.get(toolName));
	}

	public void mousePressed(int x, int y) {
		herramienta.mousePressed(x, y);
	}

	public void mouseMoved(int x, int y) {
		herramienta.mouseMoved(x, y);
	}

	public void mouseReleased(int x, int y) {
		herramienta.mouseReleased(x, y);
	}

	// $ Métodos del dibujo -----------------------------

	public Dibujo getDibujo() {
		return dibujo;
	}

	private void setHerramienta(Herramienta h) {
		this.herramienta = h;
	}

	public void addFigura(Figura figura) {
		this.dibujo.addFigura(figura);
	}

	public void finHerramienta() {
		herramienta = seleccion;
	}

	// Historial

	public void undo() {
		historial.undo();
	}

	public void redo() {
		historial.redo();
	}

	public HistorialCambios getHistorialCambios() {
		return this.historial;
	}
}
