/**
 * 
 */
package editor.comandos;

import editor.Comando;
import editor.Editor;

/**
 * 
 */
public class Insertar implements Comando {

	private StringBuilder palabras = new StringBuilder();

	public Insertar(String[] palabras) {
		if (palabras == null || palabras.length == 0)
			throw new IllegalArgumentException("Se necesita al menos una palabra a insertar");
		for (String word : palabras) {
			this.palabras.append(word + " ");
		}
	}

	@Override
	public void execute(Editor editor) {
		editor.setTexto(editor.getTexto().append(palabras.toString()));
	}

}
