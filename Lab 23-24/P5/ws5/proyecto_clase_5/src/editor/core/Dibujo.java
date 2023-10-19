package editor.core;

import java.util.*;

import editor.actions.ActionManager;
import editor.actions.CreateFigureAction;

public class Dibujo {
	List<Figura> figuras = new ArrayList<>();
	private ActionManager actionManager = new ActionManager();
	
    public void addFigura(Figura figura) {
        figuras.add(figura);
    }

    public void dibuja() {
        for (Figura figura : figuras) {
            figura.dibujar();
            actionManager.addUndoableAction(new CreateFigureAction(figura, this));
        }
    }

    public Figura getFigura(int x, int y) {
        for (Figura figura : figuras)
            if (figura.contiene(x, y))
                return figura;
        return null;
    }

    public void removeFigura(Figura figura) {
    	actionManager.executeAction(new CreateFigureAction(figura, this));
        figuras.remove(figura);
    }

	public ActionManager getActionManager() {
		return this.actionManager;
	}
}
