package editor;

import editor.actions.Abrir;
import editor.actions.Borrar;
import editor.actions.Insertar;
import editor.actions.Reemplazar;

public class Editor {

	private ActionManager actionManager = new ActionManager(this);
	private StringBuilder texto = new StringBuilder("");

	public void abrir(String file) {
		this.actionManager.execute(new Abrir(file));
	}

	public void setText(StringBuilder newText) {
		this.texto = newText;
	}

	public StringBuilder getText() {
		return this.texto;
	}

	public void insertar(String[] line) {
		this.actionManager.execute(new Insertar(line));
	}

	public void borrar() {
		this.actionManager.execute(new Borrar());
	}

	public void reemplazar(String source, String target) {
		this.actionManager.execute(new Reemplazar(source, target));
	}

	public void grabar(String macro) {
		this.actionManager.grabar(macro);
	}

	public void pararDeGrabar() {
		this.actionManager.pararDeGrabar();
	}

	public void ejecutarMacro(String nombre) {
		this.actionManager.ejecutarMacro(nombre);
	}

}
