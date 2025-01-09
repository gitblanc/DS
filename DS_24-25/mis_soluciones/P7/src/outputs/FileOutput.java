/**
 * 
 */
package outputs;

import java.io.FileWriter;
import java.io.IOException;

import files.Output;

/**
 * 
 */
public class FileOutput implements Output {

	private FileWriter writer;

	public FileOutput(String newName) throws IOException {
		writer = new FileWriter(newName);
	}

	@Override
	public void send(char c) throws IOException {
		writer.append((char) c);
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}

}
