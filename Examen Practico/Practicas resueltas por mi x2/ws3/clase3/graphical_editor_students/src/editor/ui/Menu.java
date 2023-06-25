package editor.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

import editor.core.Editor;
import editor.core.Tool;
import editor.tools.CircleCreationTool;
import editor.tools.RectangleCreationTool;
import editor.tools.TriangleCreationTool;

public class Menu {

	private BufferedReader input;
	private PrintWriter output;
	private boolean exit = false;
	private Editor editor;

	private Tool selection, rectangle, circle, triangle;

	public Menu(Editor e) {
		this(e, System.in, System.out);
	}

	public Menu(Editor e, InputStream in, PrintStream out) {
		this(e, new BufferedReader(new InputStreamReader(in)), new PrintWriter(out));

	}

	public Menu(Editor e, BufferedReader in, PrintWriter out) {
		this.editor = e;
		this.input = in;
		this.output = out;
		selection = editor.getDefaultTool();
		rectangle = new RectangleCreationTool(this.editor);
		circle = new CircleCreationTool(this.editor);
		triangle = new TriangleCreationTool(this.editor);
	}

	public void run() throws IOException {
		showHelp();
		while (!exit) {
			askUser();
		}
		output.println("¡Adios!");
		return;
	}

	private void showHelp() {
		output.println("");
		output.println("Herramientas: seleccion - rectangulo - circulo - triangulo");
		output.println("Acciones del ratón: pulsar <x>,<y> - mover <x>,<y> - soltar");
		output.println("Otras acciones: dibujar - ayuda - salir");
		output.println("-----------------------------------------------------------");
	}

	private void askUser() throws IOException {
		output.print("> ");
		output.flush();
		String[] tokens = input.readLine().split("[ ]", 2);
		String action = tokens[0];

		// Para las acciones que contienen parámetros
		if (action.equals("pulsar") || action.equals("mover")) {
			try {
				String[] arguments = tokens[1].split("\\s*,\\s*");
				int x = Integer.parseInt(arguments[0]);
				int y = Integer.parseInt(arguments[1]);
				if (action.equals("pulsar"))
					editor.clickedOn(x, y);
				else if (action.equals("mover"))
					editor.movedTo(x, y);
				else
					throw new AssertionError("Sólo se puede pulsar o mover");

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return;
		}
		// Para las que no tienen parámetros
		if (tokens.length > 1) {
			output.printf("Error de sintaxis: \"%s\" no tiene parámetros%n", action);
			return;
		}

		if (action.equals("soltar"))
			editor.released();
		else if (action.equals("dibujar"))
			editor.drawDocument();
		else if (action.equals("ayuda"))
			showHelp();
		else if (action.equals("salir"))
			exit = true;
		else if (action.equals("seleccion"))
			editor.selectTool(selection);
		else if (action.equals("rectangulo"))
			editor.selectTool(rectangle);
		else if (action.equals("circulo"))
			editor.selectTool(circle);
		else if (action.equals("triangulo"))
			editor.selectTool(triangle);
		else {
			output.println("Acción desconocida");
			showHelp();
		}
	}

}