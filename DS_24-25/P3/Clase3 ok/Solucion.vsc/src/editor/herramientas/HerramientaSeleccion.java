package editor.herramientas;

import java.awt.Point;

import editor.core.*;

public class HerramientaSeleccion implements Herramienta {

    private EditorWindow editor;

    private Figura seleccionada;
    private Point posicionAnterior;

    public HerramientaSeleccion(EditorWindow editor) {
        this.editor = editor;
    }

    public void mousePressed(int x, int y) {
        seleccionada = editor.getDibujo().getFigura(x, y);
        posicionAnterior = new Point(x, y);
    }

    public void mouseMoved(int x, int y) {
        mueveIncremento(x, y);
    }

    public void mouseReleased(int x, int y) {
        mueveIncremento(x, y);
    }

    private void mueveIncremento(int x, int y) {
        if (seleccionada != null) {
            seleccionada.mover(x - posicionAnterior.x, y - posicionAnterior.y);
            posicionAnterior = new Point(x, y);
        }
    }

}
