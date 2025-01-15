/**
 * 
 */
package editor;

import editor.actions.DeleteLastWord;
import editor.actions.Insert;
import editor.actions.Open;
import editor.actions.Replace;

/**
 * @author omenp
 *
 */
public class Editor {
	private StringBuilder text = new StringBuilder();
	private ActionManager manager = new ActionManager(this);

	public void open(String file) {
		manager.execute(new Open(file));
	}

	public void insert(String[] words) {
		manager.execute(new Insert(words));
	}

	public void removeLastWord() {
		manager.execute(new DeleteLastWord());
	}

	public void replace(String oldString, String newString) {
		manager.execute(new Replace(oldString, newString));
	}

	public StringBuilder getText() {
		return text;
	}

	public void setText(StringBuilder newText) {
		this.text = newText;
	}

	public void recordMacro(String macro) {
		manager.record(macro);
	}

	public void stopMacro() {
		manager.stop();
	}

	public void executeMacro(String macro) {
		manager.executeMacro(macro);
	}
}
