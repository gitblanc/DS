package editor.actions;

import editor.Editor;

public class Insertar implements Action {

	private StringBuilder text = new StringBuilder();

	public Insertar(String[] line) {
		if (line == null || line.length == 0)
			throw new IllegalArgumentException("Se necesita al menos una palabra a insertar");
		for (String word : line) {
			text.append(word + " ");
		}
	}

	@Override
	public void execute(Editor editor) {
		editor.setText(editor.getText().append(text));
	}

}
