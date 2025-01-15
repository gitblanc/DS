/**
 * 
 */
package outputs.filters;

import java.io.IOException;

import outputs.Output;

/**
 * @author omenp
 *
 */
public class Encryptor extends AbstractFilter implements Output {

	public Encryptor(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		output.send((char) (Character.isLetterOrDigit(c) ? c+1 : c));
	}

}
