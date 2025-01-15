package filters;

import java.io.IOException;

import output.Output;

public class Encryptor extends AbstractFilter implements Output {

	public Encryptor(Output o) {
		super(o);
	}

	@Override
	public void send(char c) throws IOException {
		output.send((char) (Character.isLetterOrDigit(c) ? c + 1 : c));
	}

}
