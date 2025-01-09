package editor.core;

import java.util.*;

import editor.herramientas.HerramientaSeleccion;
import figuras.circulo.HerramientaCirculo;
import figuras.rectangulo.HerramientaRectangulo;
import figuras.triangulo.HerramientaTriangulo;

public class EditorWindow {

    private Dibujo dibujo;
    private Map<String, Herramienta> herramientas;
    private Herramienta herramienta;
    private Herramienta seleccion;

    private Historial historial;

    public EditorWindow() {
        dibujo = new Dibujo();

        herramientas = new HashMap<>();
        doCreaHerramientas(herramientas);
        herramienta = seleccion = herramientas.get("seleccion");

        historial = new Historial();
    }

    protected void doCreaHerramientas(Map<String, Herramienta> herramientas) {
        herramientas.put("rectangulo", new HerramientaRectangulo(this));
        herramientas.put("circulo", new HerramientaCirculo(this));
        herramientas.put("triangulo", new HerramientaTriangulo(this));
        herramientas.put("seleccion", new HerramientaSeleccion(this));
    }

    //# Métodos del Historial -----------------------------

    public Historial getHistorial() {
        return historial;
    }

    public void undo() {
        historial.undo();
    }

    public void redo() {
        historial.redo();
    }

    //# Métodos del Interfaz de Usuario -----------------------------

    public void toolButtonClicked(String nombre) {
        setHerramienta(herramientas.get(nombre));
    }

    public void mousePressed(int x, int y) {
        herramienta.mousePressed(x, y);
    }

    public void mouseMoved(int x, int y) {
        herramienta.mouseMoved(x, y);
    }

    public void mouseReleased(int x, int y) {
        herramienta.mouseReleased(x, y);
    }

    //# Métodos de Herramientas ---------------------

    private void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public void finHerramienta() {
        herramienta = seleccion;
    }

    //# Métodos del dibujo -----------------------------

    public Dibujo getDibujo() {
        return dibujo;
    }

    public void dibuja() {

        // Se dibuja el menú
        // Se dibuja la barra de herramientas lateral
        // Se dibuja la línea de estado

        dibujo.dibuja();

        System.out.println("  [" + herramienta.getClass().getSimpleName() + " activada]");
        System.out.println();
    }

}
