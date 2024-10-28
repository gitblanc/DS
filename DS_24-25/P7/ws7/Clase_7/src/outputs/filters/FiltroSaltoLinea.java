/**
 * 
 */
package outputs.filters;

import java.io.IOException;

import files.Output;

/**
 * 
 */
public class FiltroSaltoLinea extends FiltroAbstracto implements Output {

	public FiltroSaltoLinea(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		if (c != '\r')
			super.out.send(c);
	}

}
