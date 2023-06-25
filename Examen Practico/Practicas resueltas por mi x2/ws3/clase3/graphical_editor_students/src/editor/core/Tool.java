package editor.core;

public interface Tool {

	void release();

	void clickOn(int x, int y);

	void moveTo(int x, int y);

	void unselect();

}
