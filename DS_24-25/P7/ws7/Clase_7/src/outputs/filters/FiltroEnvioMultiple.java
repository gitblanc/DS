/**
 * 
 */
package outputs.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import files.Output;

/**
 * 
 */
public class FiltroEnvioMultiple implements Output {

	private List<Output> outputs = new ArrayList<>();

	public FiltroEnvioMultiple(Output... outputs) {
		for (int i = 0; i < outputs.length; i++)
			this.outputs.add(outputs[i]);
	}

	@Override
	public void send(char c) throws IOException {
		for (int i = 1; i < outputs.size(); i++)
			outputs.get(i).send(c);
	}

	public void close() throws IOException {
		for (int i = 1; i < outputs.size(); i++)
			outputs.get(i).close();
	}
}
