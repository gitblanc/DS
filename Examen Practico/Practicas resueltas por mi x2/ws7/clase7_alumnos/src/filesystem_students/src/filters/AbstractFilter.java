package filters;

import java.io.IOException;

import output.Output;

public abstract class AbstractFilter implements Output {

	protected Output output;

	public AbstractFilter(Output o) {
		this.output = o;
	}

	public void close() throws IOException {
		output.close();
	}
}
