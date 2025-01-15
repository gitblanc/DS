package editor.herramientas;

import java.awt.Point;

import editor.core.*;

public class HerramientaSeleccion implements Herramienta {

    public HerramientaSeleccion(Editor editor) {
        this.editor = editor;
    }

    public void pinchar(int x, int y) {
        seleccionada = editor.getDibujo().getFigura(x, y);
        lastPosition = new Point(x, y);
    }

    public void mover(int x, int y) {
        mueveIncremento(x, y);
    }

    public void soltar(int x, int y) {
        mueveIncremento(x, y);
    }

    private void mueveIncremento(int x, int y) {
        if (seleccionada != null) {
            seleccionada.mover(x - lastPosition.x, y - lastPosition.y);
            lastPosition = new Point(x, y);
        }
    }

    private Point lastPosition;

    private Editor editor;
    private Figura seleccionada;
}
