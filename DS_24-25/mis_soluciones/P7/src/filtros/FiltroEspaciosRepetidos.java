/**
 * 
 */
package filtros;

import java.io.IOException;

import files.Output;

/**
 * 
 */
public class FiltroEspaciosRepetidos implements Output {

	private Output output;
	private char ultimoChar;

	public FiltroEspaciosRepetidos(Output o) {
		this.output = o;
	}

	@Override
	public void send(char c) throws IOException {
		if (c == ' ' && ultimoChar == ' ')
			return;
		else {
			ultimoChar = c;
			output.send(c);
		}
	}

	@Override
	public void close() throws IOException {
		output.close();
	}

}
