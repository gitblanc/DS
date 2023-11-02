package filters;

import java.io.IOException;

import fileSystem.Output;

public class NormalizarSaltosLinea extends AbstractFilter implements Output {

	public NormalizarSaltosLinea(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		if (c != '\r')
			output.send(c);
	}

}
