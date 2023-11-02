package filters;

import java.io.IOException;

import fileSystem.Output;

public class Encrypt extends AbstractFilter implements Output {

	public Encrypt(Output o) {
		super(o);
	}

	@Override
	public void send(char c) throws IOException {
		if (Character.isLetter(c) || Character.isDigit(c))
			this.output.send(((char) (c + 1)));
	}

}
