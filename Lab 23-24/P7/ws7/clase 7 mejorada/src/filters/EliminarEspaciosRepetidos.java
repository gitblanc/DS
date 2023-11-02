/**
 * 
 */
package filters;

import java.io.IOException;

import fileSystem.Output;

/**
 * @author blanc
 *
 */
public class EliminarEspaciosRepetidos extends AbstractFilter implements Output {

	private char lastSpace = 0;

	public EliminarEspaciosRepetidos(Output o) {
		super(o);
	}

	@Override
	public void send(char c) throws IOException {
		if (c == ' ' && lastSpace == ' ') {
			return;
		}
		output.send(c);
		lastSpace = c;
	}

}
