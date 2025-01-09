package files;

import java.io.IOException;

public interface Output {

	void send(char c) throws IOException;

	void close() throws IOException;

}
