/**
 * 
 */
package CH.ifa.draw.samples.nada;

import java.awt.Point;

import CH.ifa.draw.framework.DrawingView;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.CreationTool;

/**
 * @author blanc
 *
 */
public class EjemploTool extends CreationTool {
	/**
	 * @param view
	 */
	public EjemploTool(DrawingView view) {
		//view.lastClick(), view.lastClick()
		super(view, new EjemploFigure());
	}
}
