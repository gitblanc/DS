/**
 * 
 */
package editor.comandos;

import java.util.regex.Pattern;

import editor.Comando;
import editor.Editor;

/**
 * 
 */
public class Reemplazar implements Comando {

	private String s1, s2;

	public Reemplazar(String string, String string2) {
		this.s1 = string;
		this.s2 = string2;
	}

	@Override
	public void execute(Editor editor) {
		editor.setTexto(new StringBuilder(editor.getTexto().toString().replaceAll(Pattern.quote(s1), s2)));
	}

}
