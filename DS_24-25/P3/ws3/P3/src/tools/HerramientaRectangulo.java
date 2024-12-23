package tools;

import editor.core.EditorWindow;
import editor.core.Lienzo;
import figuras.Figura;
import figuras.Rectangulo;

public class HerramientaRectangulo extends HerramientaCreacion {

	public HerramientaRectangulo(EditorWindow editor) {
		super(editor);
	}

	@Override
	public Figura crearFigura(Lienzo l) {
		return new Rectangulo(l);
	}

	@Override
	public String toString() {
		return "Herramienta de creación de rectángulo";
	}
}
