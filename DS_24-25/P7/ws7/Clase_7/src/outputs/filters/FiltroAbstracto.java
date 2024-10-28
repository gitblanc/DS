/**
 * 
 */
package outputs.filters;

import java.io.IOException;

import files.Output;

/**
 * 
 */
public abstract class FiltroAbstracto implements Output {

	protected Output out;

	public FiltroAbstracto(Output output) {
		this.out = output;
	}

	public void close() throws IOException {
		this.out.close();
	}
}
