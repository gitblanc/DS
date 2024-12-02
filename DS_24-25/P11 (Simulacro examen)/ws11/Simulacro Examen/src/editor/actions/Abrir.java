/**
 * 
 */
package editor.actions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import editor.Editor;

/**
 * 
 */
public class Abrir implements Action {

	private String filename;

	public Abrir(String file) {
		this.filename = file;
	}

	@Override
	public void execute(Editor editor) {
		try {
			editor.setText(readFile(this.filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static StringBuilder readFile(String filename) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder result = new StringBuilder();
		while ((line = input.readLine()) != null) {
			result.append(line);
		}
		input.close();
		return result;
	}

}
