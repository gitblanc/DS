package editor.actions;

import editor.Editor;
import java.util.regex.Pattern;

public class Reemplazar implements Action {

	private String source, target;

	public Reemplazar(String source, String target) {
		this.source = source;
		this.target = target;
	}

	@Override
	public void execute(Editor editor) {
		editor.setText(new StringBuilder(editor.getText().toString().replaceAll(Pattern.quote(source), target)));
	}

}
