package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import editor.core.EditorWindow;
import tools.Herramienta;
import tools.HerramientaCirculo;
import tools.HerramientaRectangulo;
import tools.HerramientaTriangulo;

public class Menu {

	private EditorWindow editor;
	private Herramienta seleccion, rectangulo, circulo, triangulo;

	public Menu(EditorWindow editor) {
		this.setEditor(editor);
		seleccion = editor.getDefaultHerramienta();
		rectangulo = new HerramientaRectangulo(editor);
		circulo = new HerramientaCirculo(editor);
		triangulo = new HerramientaTriangulo(editor);
	}

	public void ejecutar() throws IOException {
		mostrarAyuda();
		do {
			preguntarUsuario();
		} while (true);
	}

	private void preguntarUsuario() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("$> ");
		String[] line = in.readLine().split("[ ,]");

		if (line[0].equals("exit"))
			return;

		if (line[0].equals("help"))
			mostrarAyuda();

		// $ Pulsación de los botones de las herramientas -----------------------------
		if (line[0].startsWith("sel"))
			editor.setHerramientaActual(seleccion);

		else if (line[0].startsWith("rect"))
			editor.setHerramientaActual(rectangulo);

		else if (line[0].startsWith("circ"))
			editor.setHerramientaActual(circulo);

		else if (line[0].startsWith("trian"))
			editor.setHerramientaActual(triangulo);

		// $ Acciones del Ratón -----------------------------

		else if (line[0].startsWith("pin"))
			editor.mousePressed(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

		else if (line[0].startsWith("mov"))
			editor.mouseMoved(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

		else if (line[0].startsWith("sol"))
			editor.mouseReleased(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

		// $ Otros comandos -----------------------------

		else if (line[0].startsWith("dib"))
			editor.dibuja();

		else
			System.out.println("Comando no válido");
	}

	private void mostrarAyuda() {
		System.out.println("\nActivación de Herramientas: rectangulo | circulo | triangulo | seleccion");
		System.out.println("Acciones de Ratón: pinchar x,y | mover x,y | soltar x,y");
		System.out.println("Otros Comandos: dibujar | exit | help \n");
	}

	public EditorWindow getEditor() {
		return editor;
	}

	public void setEditor(EditorWindow editor) {
		this.editor = editor;
	}
}