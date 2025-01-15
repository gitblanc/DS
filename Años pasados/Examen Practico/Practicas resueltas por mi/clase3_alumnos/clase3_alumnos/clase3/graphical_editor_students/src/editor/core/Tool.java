/**
 * 
 */
package editor.core;

/**
 * @author omenp
 *
 */
public interface Tool {
	void clickOn(int x, int y);
	void moveTo(int x, int y);
	void release();
	//Para inicializar su estado despues de que sean usadas
	void unselect();
}
