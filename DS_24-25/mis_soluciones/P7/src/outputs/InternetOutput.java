/**
 * 
 */
package outputs;

import java.io.IOException;
import java.io.StringWriter;

import files.Output;

/**
 * 
 */
public class InternetOutput implements Output {

	StringWriter stringWriter;

	public InternetOutput(String url) {
		stringWriter = new StringWriter();
		stringWriter.append("\n--- START. Conectando a Internet[" + url + "]\n");
	}

	@Override
	public void send(char c) throws IOException {
		stringWriter.append((char) c);
	}

	@Override
	public void close() throws IOException {
		System.out.print(stringWriter.toString());
		System.out.println("--- END. Cerrando conexión a Internet");
	}

}
