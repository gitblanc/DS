/**
 * 
 */
package outputs.filters;

import java.io.IOException;

import files.Output;

/**
 * 
 */
public class FiltroEncriptar extends FiltroAbstracto implements Output {

	public FiltroEncriptar(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		if (Character.isLetterOrDigit(c))
			out.send((char) (c + 1));
		out.send(c);
	}

}
