/**
 * 
 */
package filtros;

import java.io.IOException;

import files.Output;

/**
 * 
 */
public class FiltroContarCaracteres implements Output {

	private Output output;
	private int contador;

	public FiltroContarCaracteres(Output output) {
		this.output = output;
		contador = 0;
	}

	@Override
	public void send(char c) throws IOException {
		contador += 1;
		output.send(c);
	}

	@Override
	public void close() throws IOException {
		output.close();
	}

	public int getContador() {
		return this.contador;
	}
}
