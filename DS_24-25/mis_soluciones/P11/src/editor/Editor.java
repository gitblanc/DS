/**
 * 
 */
package editor;

import editor.comandos.Abrir;
import editor.comandos.Borrar;
import editor.comandos.Insertar;
import editor.comandos.Reemplazar;

/**
 * 
 */
public class Editor {

	private StringBuilder texto = new StringBuilder("");
	private ActionManager actionManager = new ActionManager(this);

	public void abrir(String file) {
		actionManager.execute(new Abrir(file));
	}

	public void insertar(String[] palabras) {
		actionManager.execute(new Insertar(palabras));
	}

	public void borrar() {
		actionManager.execute(new Borrar());
	}

	public void reemplazar(String string, String string2) {
		actionManager.execute(new Reemplazar(string, string2));
	}

	public void mostrarTexto() {
		System.out.println(texto.toString());
	}

	public StringBuilder getTexto() {
		return this.texto;
	}

	public void setTexto(StringBuilder texto) {
		this.texto = texto;
	}

	public void grabar(String nombreMacro) {
		actionManager.grabar(nombreMacro);
	}

	public void pararDeGrabar() {
		actionManager.pararDeGrabar();
	}

	public void ejecutaMacro(String nombre) {
		actionManager.ejecutaMacro(nombre);
	}

}
