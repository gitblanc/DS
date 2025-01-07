package editor.core;

public class EditorWindow {

    private Dibujo dibujo;

    public EditorWindow() {
        dibujo = new Dibujo();

    }

    public void dibuja() {

        // Se dibuja el menú
        // Se dibuja la barra de herramientas lateral
        // Se dibuja la línea de estado

        dibujo.dibuja();
    }

    //$ Métodos del Interfaz de Usuario -----------------------------

    // Se pinchar el botón de una herramienta para activarla
    public void toolButtonClicked(String toolName) {
        // ?
    }

    public void mousePressed(int x, int y) {
        // ?
    }

    public void mouseMoved(int x, int y) {
        // ?
    }

    public void mouseReleased(int x, int y) {
        // ?
    }

    //$ Métodos del dibujo -----------------------------

    public Dibujo getDibujo() {
        return dibujo;
    }

}
