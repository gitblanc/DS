package editor.herramientas;

import java.awt.Point;

import editor.cambios.CambioMovimiento;
import editor.core.*;

public class HerramientaSeleccion implements Herramienta {

    public HerramientaSeleccion(EditorWindow editor) {
        this.editor = editor;
    }

    public void mousePressed(int x, int y) {
        seleccionada = editor.getDibujo().getFigura(x, y);
        start = end = new Point(x, y);
    }

    public void mouseMoved(int x, int y) {
        mueveIncremento(x, y);
    }

    public void mouseReleased(int x, int y) {
        mueveIncremento(x, y);

        if (seleccionada != null)
            editor.getHistorial()
                    .registraCambio(new CambioMovimiento(seleccionada, end.x - start.x, end.y - start.y));
    }

    private void mueveIncremento(int x, int y) {
        if (seleccionada != null) {
            seleccionada.mover(x - end.x, y - end.y);
            end = new Point(x, y);
        }
    }

    private Point start, end;

    private EditorWindow editor;
    private Figura seleccionada;
}
