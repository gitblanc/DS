/**
 * 
 */
package editor.actions;

import java.util.regex.Pattern;

import editor.Editor;

/**
 * @author omenp
 *
 */
public class Replace implements Action {

	private String old, news;

	public Replace(String oldString, String newString) {
		if (oldString == null || newString == null)
			throw new IllegalArgumentException("Los parámetros no pueden ser nulos");
		this.old = oldString;
		this.news = newString;
	}

	@Override
	public void execute(Editor editor) {
		editor.setText(new StringBuilder(editor.getText().toString().replaceAll(Pattern.quote(old), news)));
	}

	@Override
	public String toString() {
		return "Reemplazar " + old + " por " + news;
	}

}
