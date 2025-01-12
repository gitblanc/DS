/**
 * 
 */
package editor.comandos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import editor.Comando;
import editor.Editor;

/**
 * 
 */
public class Abrir implements Comando {

	private String file;

	public Abrir(String file) {
		this.file = file;
	}

	@Override
	public void execute(Editor editor) {
		try {
			editor.setTexto(readFile(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private StringBuilder readFile(String filename) throws IOException {
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
