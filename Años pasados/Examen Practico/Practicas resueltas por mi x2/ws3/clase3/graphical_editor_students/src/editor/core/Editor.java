package editor.core;

import java.io.PrintStream;
import java.io.PrintWriter;

import editor.tools.SelectionTool;

public class Editor {
	private Drawing drawing = new Drawing();
	private PrintWriter output;
	private Tool defaultTool;
	private Tool currentTool;
	private static boolean DEBUG = false;

	public Editor() {
		this(System.out);
	}

	public Editor(PrintStream out) {
		output = new PrintWriter(out, true);
		currentTool = defaultTool = createDefaultTool();
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
		output.println("Herramienta seleccionada: " + currentTool);
		drawing.draw(output);
	}

	public Tool getDefaultTool() {
		return this.defaultTool;
	}

	public void clickedOn(int x, int y) {
		currentTool.clickOn(x, y);
	}

	public void movedTo(int x, int y) {
		currentTool.moveTo(x, y);
	}

	public void released() {
		currentTool.release();
	}

	public void selectTool(Tool tool) {
		if (tool == null)
			throw new IllegalArgumentException("La herramienta no puede ser nula");
		currentTool.unselect();
		currentTool = tool;
		trace("Se seleccionó la herramienta: " + tool);
	}

	public void trace(String message) {
		if (DEBUG)
			output.println("message");
	}

	public void toolDone() {
		selectTool(defaultTool);
	}
}
