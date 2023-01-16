package editor.core;

import java.io.PrintStream;
import java.io.PrintWriter;

import editor.tools.SelectionTool;

public class Editor {
	private Drawing drawing = new Drawing();
	private PrintWriter output;
	private Tool defaultTool;
	private Tool selectedTool;

	public Editor() {
		this(System.out);
	}

	public Editor(PrintStream out) {
		output = new PrintWriter(out, true);
		selectedTool = defaultTool = createDefaultTool();
	}

	private Tool createDefaultTool() {
		return new SelectionTool(this);
	}

	public Drawing getDrawing() {
		return drawing;
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public void drawDocument() {
		output.println("Herramienta seleccionada: " + selectedTool);
		drawing.draw(output);
	}

	public void clickedOn(int x, int y) {
		selectedTool.clickOn(x, y);
	}

	public void movedTo(int x, int y) {
		selectedTool.moveTo(x, y);
	}

	public void released() {
		selectedTool.release();
	}

	public void selectTool(Tool tool) {
		if (tool == null)
			throw new IllegalArgumentException("¡No se puede seleccionar una herramienta nula!");
		selectedTool.unselect();
		selectedTool = tool;
	}

	public void toolDone() {
		selectTool(defaultTool);
	}

	public Tool getDefaultTool() {
		return defaultTool;
	}
}
