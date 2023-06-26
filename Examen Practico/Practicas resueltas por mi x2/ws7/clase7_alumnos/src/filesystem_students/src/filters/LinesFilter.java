package filters;

import java.io.IOException;

import output.Output;

public class LinesFilter extends AbstractFilter implements Output {

	public LinesFilter(Output o) {
		super(o);
	}

	@Override
	public void send(char c) throws IOException {
		if (c != '\n')
			output.send(c);
	}

}
