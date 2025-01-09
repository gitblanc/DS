/**
 * 
 */
package outputs;

import java.io.IOException;
import java.io.StringWriter;

import files.Output;

/**
 * 
 */
public class BluetoothOutput implements Output {

	StringWriter stringWriter;

	public BluetoothOutput(String device) throws IOException {
		stringWriter = new StringWriter();
		stringWriter.append("\n--- START. Conectando con Bluetooth[" + device + "]\n");
	}

	@Override
	public void send(char c) throws IOException {
		stringWriter.append((char) c);
	}

	@Override
	public void close() throws IOException {
		System.out.print(stringWriter.toString());
		System.out.println("--- END. Cerrando conexión Bluetooth");
	}

}
