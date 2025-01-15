package filters;

import java.io.IOException;

import output.Output;

public class Counter extends AbstractFilter {

	private int counter;

	public Counter(Output o) {
		super(o);
	}

	@Override
	public void send(char c) throws IOException {
		output.send(c);
		counter += 1;
	}

	public int getCounter() {
		return counter;
	}

}
