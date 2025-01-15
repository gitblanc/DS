/**
 * 
 */
package editor.actions;

import editor.Editor;

/**
 * @author omenp
 *
 */
public class Insert implements Action {

	private StringBuilder text = new StringBuilder();

	public Insert(String[] words) {
		if (words == null || words.length == 0)
			throw new IllegalArgumentException("¡La acción de insertar texto requiere nuevo texto!");
		for (String s : words)
			text.append(s + " ");
	}

	@Override
	public void execute(Editor editor) {
		editor.setText(editor.getText().append(text));
	}

	@Override
	public String toString() {
		return "Insertar " + text;
	}

}
