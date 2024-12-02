package main;

import java.io.IOException;

import editor.Editor;
import editor.ui.EditorUI;

public class Main {

	public static void main(String[] args) throws IOException {
		Editor editor = new Editor();
		EditorUI editorUI = new EditorUI(editor);
		editorUI.run();
	}
}
