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
public class LinesFilter extends AbstractFilter implements Output {

	public LinesFilter(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		if(c != '\r')
			output.send(c);
	}

}
