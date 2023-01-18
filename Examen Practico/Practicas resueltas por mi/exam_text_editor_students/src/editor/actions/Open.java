/**
 * 
 */
package editor.actions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import editor.Editor;

/**
 * @author omenp
 *
 */
public class Open implements Action {

	private String file;

	public Open(String file) {
		if (file == null || file.trim().length() == 0)
			throw new IllegalArgumentException("¡La acción de abrir un fichero necesita el nombre del fichero!");
		this.file = file;
	}

	@Override
	public void execute(Editor editor) {
		try {
			editor.setText(readFile(file));
		} catch (IOException e) {
			System.out.printf("No se pudo abrir el archivo '%s': '%s'", file, e.getMessage());
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

	@Override
	public String toString() {
		return "Abrir " + file;
	}
}
