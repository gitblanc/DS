/**
 * 
 */
package outputs.filters;

import java.io.IOException;

import files.Output;

/**
 * 
 */
public class FiltroContarCaracteres extends FiltroAbstracto implements Output {

	private int contador = 0;

	public FiltroContarCaracteres(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		out.send(c);
		contador++;
	}

	public int getContador() {
		return contador;
	}

}
