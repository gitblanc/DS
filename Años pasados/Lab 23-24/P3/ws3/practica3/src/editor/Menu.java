package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import tools.Tool;

public class Menu {

	private Editor editor;
	private Map<String, Tool> tools = new HashMap<>();
	private BufferedReader input;
	private PrintWriter output;
	private boolean salir = false;

	public Menu(Editor editor) {
		this(editor, System.in, System.out);
	}

	public Menu(Editor editor, InputStream input, PrintStream output) {
		this(editor, new BufferedReader(new InputStreamReader(input)), new PrintWriter(output, true));
	}

	public Menu(Editor editor, BufferedReader input, PrintWriter output) {
		this.editor = editor;
		this.input = input;
		this.output = output;
	}

	public void run() throws IOException {
		showMenu();
		do {
			askUser();
		} while (!salir);

	}

	public void showMenu() {
		output.println("-------------------------------------------------------------------------");
		output.println("Comandos de Herramientas: rectangulo | circulo | triangulo | seleccion");
		output.println("Comandos de Ratón: pinchar x,y | mover x,y | soltar x,y");
		output.println("Otros Comandos: dibujar | exit | ayuda");
		output.println("-------------------------------------------------------------------------");
	}

	public void askUser() throws IOException {

		output.print("$ ");
		String[] line = input.readLine().split("[ ,]");

		if (line[0].equals("exit")) {
			salir = true;
			return;
		}
		if (line[0].equals("ayuda"))
			showMenu();
		else if (line[0].equals("pinchar")) {
			int x = Integer.parseInt(line[1]);
			int y = Integer.parseInt(line[2]);
			editor.pinchar(x, y);
		} else if (line[0].equals("mover")) { // Esto es mover el ratón
			int x = Integer.parseInt(line[1]);
			int y = Integer.parseInt(line[2]);
			editor.mover(x, y);
		} else if (line[0].equals("soltar")) {
			int x = Integer.parseInt(line[1]);
			int y = Integer.parseInt(line[2]);
			editor.soltar(x, y);
		} else if (line[0].equals("dibujar")) {
			editor.dibujar();
		} else if (tools.containsKey(line[0])) {
			Tool tool = tools.get(line[0]);
			editor.setCurrentTool(tool);
		} else
			output.println("Comando no válido");
	}

	public Editor getEditor() {
		return editor;
	}

	public void addTool(String key, Tool tool) {
		tools.put(key, tool);
	}

}
