/**
 * 
 */
package outputs.filters;

import java.io.IOException;

import files.Output;

/**
 * 
 */
public class FiltroEliminarEspacios extends FiltroAbstracto implements Output {

	private char ultimoCaracter;

	public FiltroEliminarEspacios(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		if (c == ' ' && ultimoCaracter == ' ')
			return;
		else {
			ultimoCaracter = c;
			out.send(c);
		}

	}

}
