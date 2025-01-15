package figures;

import java.io.PrintWriter;

public interface Figure {

	boolean contains(int x, int y);

	void draw(PrintWriter output);

	void move(int x, int y);

}
