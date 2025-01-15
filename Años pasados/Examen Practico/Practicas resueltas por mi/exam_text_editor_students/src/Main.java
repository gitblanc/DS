import java.io.IOException;

import editor.Editor;
import editor.ui.Menu;

public class Main 
{
	
	public static void main(String[] args) throws IOException {
		Editor editor = new Editor();
		Menu console = new Menu(editor);
		console.run();
	}
}
