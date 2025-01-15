package filters;

import java.io.IOException;

import output.Output;

public class Fork extends AbstractFilter {

	private Output output2;

	public Fork(Output o1, Output o2) {
		super(o1);
		this.output2 = o2;
	}

	public void send(char c) throws IOException {
		output.send(c);
		output2.send(c);
	}

	public void close() throws IOException {
		super.close();
		output2.close();
	}

}
