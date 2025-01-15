package editor.core;

import java.io.*;

import editor.herramientas.HerramientaSeleccion;
import figuras.circulo.HerramientaCirculo;
import figuras.rectangulo.HerramientaRectangulo;
import figuras.triangulo.HerramientaTriangulo;

public class Editor {

    public Editor() {
        setDibujo(new Dibujo());

        doCreateTools();
    }

    protected void doCreateTools() {
        rectangulo = new HerramientaRectangulo(this);
        circulo = new HerramientaCirculo(this);
        triangulo = new HerramientaTriangulo(this);
        actual = defaultTool = createDefaultTool();
    }

    protected Herramienta createDefaultTool() {
        return new HerramientaSeleccion(this);
    }

    public void run() throws IOException {
        System.out.println("Comandos de Herramientas: rectangulo | circulo | triangulo | seleccion");

        System.out.println("Comandos de Ratón: pinchar x,y | mover x,y | soltar x,y");
        System.out.println("Otros Comandos: dibujar | exit");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print(">");
            String[] line = in.readLine().split("[ ,]");

            if (line[0].equals("exit"))
                return;

            if (line[0].equals("rectangulo"))
                // La activación de herramientas podría simplificarse usando una tabla hash
                setHerramienta(rectangulo);
            else if (line[0].equals("circulo"))
                setHerramienta(circulo);
            else if (line[0].equals("triangulo"))
                setHerramienta(triangulo);
            else if (line[0].equals("seleccion"))
                setHerramienta(getDefaultTool());
            else if (line[0].equals("pinchar"))
                actual.pinchar(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            else if (line[0].equals("mover"))
                actual.mover(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            else if (line[0].equals("soltar"))
                actual.soltar(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            else if (line[0].equals("dibujar"))
                dibujar();
            else
                System.out.println("Comando no válido");

        } while (true);
    }

    //$ Métodos del dibujo -----------------------------

    public void setDibujo(Dibujo dibujo) {
        this.dibujo = dibujo;
    }

    public Dibujo getDibujo() {
        return dibujo;
    }

    public void dibujar() {
        System.out.println("Herramienta: " + actual);
        dibujo.dibuja();
    }

    //$ Métodos de Herramientas ---------------------

    public void setHerramienta(Herramienta herramienta) {
        this.actual = herramienta;
    }

    public Herramienta getDefaultTool() {
        return defaultTool;
    }

    public void finHerramienta() {
        actual = getDefaultTool();
    }

    private Dibujo dibujo;
    private Herramienta rectangulo, circulo, triangulo;

    private Herramienta actual, defaultTool;
}
