/**
 * 
 */
package filtros;

import java.io.IOException;

import files.Output;

/**
 * 
 */
public class FiltroSaltoLinea implements Output {

	private Output output;

	public FiltroSaltoLinea(Output output) {
		this.output = output;
	}

	@Override
	public void send(char c) throws IOException {
		if (c != '\n' || c != '\r')
			output.send(c);
	}

	@Override
	public void close() throws IOException {
		output.close();
	}

}
