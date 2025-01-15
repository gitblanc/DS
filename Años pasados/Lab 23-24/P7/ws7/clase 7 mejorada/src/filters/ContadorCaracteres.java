package filters;

import java.io.IOException;

import fileSystem.Output;

public class ContadorCaracteres extends AbstractFilter implements Output {
	private int cont;

	public ContadorCaracteres(Output o) {
		super(o);
		cont = 0;
	}

	@Override
	public void send(char c) throws IOException {
		this.output.send(c);
		cont = getCont() + 1;
	}

	@Override
	public void close() throws IOException {
		super.close();
	}

	public int getCont() {
		return this.cont;
	}

}
