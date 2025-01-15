/**
 * 
 */
package filters;

import java.io.IOException;

import fileSystem.Output;

/**
 * @author blanc
 *
 */
public abstract class AbstractFilter implements Output {

	protected Output output;

	public AbstractFilter(Output o) {
		this.output = o;
	}

	public void close() throws IOException {
		this.output.close();
	}

}
