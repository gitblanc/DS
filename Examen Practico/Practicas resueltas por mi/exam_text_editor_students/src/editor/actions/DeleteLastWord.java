/**
 * 
 */
package editor.actions;

import editor.Editor;

/**
 * @author omenp
 *
 */
public class DeleteLastWord implements Action {

	@Override
	public void execute(Editor editor) {
		StringBuilder text = editor.getText();
		
		int indexOfLastWord = text.toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			text = new StringBuilder("");
		else
			text.setLength(indexOfLastWord + 1);
	}

	@Override
	public String toString()
	{
		return "Borrar la última palabra";
	}
}
