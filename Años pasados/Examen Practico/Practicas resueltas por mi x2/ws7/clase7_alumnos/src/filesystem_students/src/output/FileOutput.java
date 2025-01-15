package output;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Output {
	
	private FileWriter writer;

	public FileOutput(String string) throws IOException {
		this.writer = new FileWriter(string);
	}

	@Override
	public void send(char c) throws IOException {
		writer.append(c);
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}

}
