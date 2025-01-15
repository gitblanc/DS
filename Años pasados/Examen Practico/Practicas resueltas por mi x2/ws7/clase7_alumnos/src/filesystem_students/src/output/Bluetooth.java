package output;

import java.io.IOException;
import java.io.StringWriter;

public class Bluetooth implements Output {

	private StringWriter st;

	public Bluetooth(String device) {
		st = new StringWriter();
		st.append("\n--- START Bluetooth [" + device + "]\n");
	}

	@Override
	public void send(char c) throws IOException {
		st.append((char) c);
	}

	@Override
	public void close() throws IOException {
		System.out.println(st.toString());
		System.out.println("--- END   Bluetooth");
	}

}
