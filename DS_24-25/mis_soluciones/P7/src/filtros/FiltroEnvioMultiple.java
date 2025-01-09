/**
 * 
 */
package filtros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import files.Output;

/**
 * 
 */
public class FiltroEnvioMultiple implements Output {

	private List<Output> outputs = new ArrayList<Output>();

	public FiltroEnvioMultiple(Output... outputs) {
		this.outputs = Arrays.asList(outputs);
	}

	@Override
	public void send(char c) throws IOException {
		for (Output o : outputs)
			o.send(c);
	}

	@Override
	public void close() throws IOException {
		for (Output o : outputs)
			o.close();
	}

}
