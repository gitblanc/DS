package figuras.rectangulo;

import java.awt.Point;

import editor.core.*;
import editor.herramientas.HerramientaCreacion;

public class HerramientaRectangulo extends HerramientaCreacion {

    public HerramientaRectangulo(EditorWindow editor) {
        super(editor);
    }

    protected Figura doCreaFigura(Point inicio, Point fin) {
        return new Rectangulo(inicio, fin);
    }
}
