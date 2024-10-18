package editor.herramientas;

import java.awt.Point;

import editor.core.*;

public abstract class HerramientaCreacion implements Herramienta {

    protected EditorWindow editor;
    private Point inicio;

    protected HerramientaCreacion(EditorWindow editor) {
        this.editor = editor;
    }

    public void mousePressed(int x, int y) {
        inicio = new Point(x, y);
    }

    public void mouseMoved(int x, int y) {
    }

    public void mouseReleased(int x, int y) {
        Point fin = new Point(x, y);
        Figura figura = doCreaFigura(inicio, fin);
        editor.getDibujo().addFigura(figura);

        editor.finHerramienta();
    }

    protected abstract Figura doCreaFigura(Point inicio, Point fin);

}
