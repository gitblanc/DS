package editor.herramientas;

import java.awt.Point;

import editor.cambios.CambioCreación;
import editor.core.*;

public abstract class HerramientaCreacion implements Herramienta {

    protected EditorWindow editor;
    private Point start;

    protected HerramientaCreacion(EditorWindow editor) {
        this.editor = editor;
    }

    public void mousePressed(int x, int y) {
        start = new Point(x, y);
    }

    public void mouseMoved(int x, int y) {
    }

    public void mouseReleased(int x, int y) {

        var end = new Point(x, y);
        Figura figura = doCreaFigura(start, end);
        editor.getDibujo().addFigura(figura);

        editor.getHistorial().registraCambio(new CambioCreación(editor.getDibujo(), figura));

        editor.finHerramienta();
    }

    protected abstract Figura doCreaFigura(Point inicio, Point fin);

}
