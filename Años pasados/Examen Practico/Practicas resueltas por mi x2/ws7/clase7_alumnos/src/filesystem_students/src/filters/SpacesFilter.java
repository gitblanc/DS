package filters;

import java.io.IOException;

import output.Output;

public class SpacesFilter extends AbstractFilter implements Output {

	private char lastChar = 0;

	public SpacesFilter(Output o) {
		super(o);
	}

	@Override
	public void send(char c) throws IOException {
		if (c == ' ' && lastChar == ' ')
			return;
		output.send(c);
		lastChar = c;
	}

}
