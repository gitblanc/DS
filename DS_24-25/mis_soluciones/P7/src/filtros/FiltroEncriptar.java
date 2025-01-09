/**
 * 
 */
package filtros;

import java.io.IOException;

import files.Output;

/**
 * 
 */
public class FiltroEncriptar implements Output {

	private Output output;

	public FiltroEncriptar(Output o) {
		this.output = o;
	}

	@Override
	public void send(char c) throws IOException {
		output.send((char) (c + 1));
	}

	@Override
	public void close() throws IOException {
		output.close();
	}

}
