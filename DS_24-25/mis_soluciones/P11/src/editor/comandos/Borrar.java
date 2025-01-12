/**
 * 
 */
package editor.comandos;

import editor.Comando;
import editor.Editor;

/**
 * 
 */
public class Borrar implements Comando {

	@Override
	public void execute(Editor editor) {
		int indexOfLastWord = editor.getTexto().toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			editor.setTexto(new StringBuilder(""));
		else
			editor.getTexto().setLength(indexOfLastWord + 1);
	}

}
