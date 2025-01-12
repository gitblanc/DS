/**
 * 
 */
package editor.comandos;

import java.util.ArrayList;
import java.util.List;

import editor.Comando;
import editor.Editor;

/**
 * 
 */
public class Macro implements Comando {

	private String nombre;
	private List<Comando> comandos = new ArrayList<Comando>();

	public Macro(String nombreMacro) {
		this.nombre = nombreMacro;
	}

	@Override
	public void execute(Editor editor) {
		for (Comando c : comandos)
			c.execute(editor);
	}

	public void addComando(Comando comando) {
		comandos.add(comando);
	}

	public String getNombre() {
		return this.nombre;
	}

}
