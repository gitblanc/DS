package editor.figures;

import java.io.PrintWriter;

public interface Figure {

	boolean contains(int x, int y);

	void moveBy(int x, int y);
	
	void draw(PrintWriter output);

}
