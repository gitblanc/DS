package editor;

import java.io.PrintStream;
import java.io.PrintWriter;

import tools.SelectionTool;
import tools.Tool;

public class Editor {

	private Dibujo dibujo = new Dibujo();
	private Tool defaultTool = new SelectionTool(this);
	private Tool currentTool;
	private PrintWriter output;

	public Editor() {
		this(System.out);
	}

	public Editor(PrintStream out) {
		output = new PrintWriter(out, true);
		currentTool = defaultTool;
	}

	public void dibujar() {
		// Dibujar menú
		// Dibujar barra de herramientas lateral
		// Dibujar línea de estado
		output.println("Herramienta seleccionada: " + currentTool.toString());
		dibujo.dibujar(output);
	}

	public void setDibujo(Dibujo dibujo) {
		this.dibujo = dibujo;
	}

	public Dibujo getDibujo() {
		return dibujo;
	}

	public Tool getCurrentTool() {
		return this.currentTool;
	}

	public void setCurrentTool(Tool tool) {
		this.currentTool = tool;
	}

	public Tool getDefaultTool() {
		return this.defaultTool;
	}

	public void soltar(int x, int y) {
		currentTool.soltar(x, y);
	}

	public void mover(int x, int y) {
		currentTool.mover(x, y);
	}

	public void pinchar(int x, int y) {
		currentTool.pinchar(x, y);
	}

}
