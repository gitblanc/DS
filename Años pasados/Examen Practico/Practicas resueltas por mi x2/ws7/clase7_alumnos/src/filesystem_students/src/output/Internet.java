package output;

import java.io.IOException;
import java.io.StringWriter;

public class Internet implements Output {

	private StringWriter st;

	public Internet(String url) {
		st = new StringWriter();
		st.append("\n--- START Internet [" + url + "]\n");
	}

	@Override
	public void send(char c) throws IOException {
		st.append((char) c);
	}

	@Override
	public void close() throws IOException {
		System.out.println(st.toString());
		System.out.println("--- END   Internet");
	}

}
