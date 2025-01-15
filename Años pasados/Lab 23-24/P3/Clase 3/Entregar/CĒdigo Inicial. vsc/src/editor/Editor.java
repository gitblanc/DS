package editor;

import java.io.*;

public class Editor {

    private Dibujo dibujo;

    public Editor() {
        dibujo = new Dibujo();
    }

    public void dibujar() {
        // Dibujar menú
        // Dibujar barra de herramientas lateral
        // Dibujar línea de estado
        dibujo.dibujar();
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
                ; //	?
            else if (line[0].equals("circulo"))
                ; //	?
            else if (line[0].equals("triangulo"))
                ; //	?
            else if (line[0].equals("seleccion"))
                ; //	?
            else if (line[0].equals("pinchar")) {
                int x = Integer.parseInt(line[1]);
                int y = Integer.parseInt(line[2]);
                //	?
            } else if (line[0].equals("mover")) { // Esto es mover el ratón
                int x = Integer.parseInt(line[1]);
                int y = Integer.parseInt(line[2]);
                //	?
            } else if (line[0].equals("soltar")) {
                int x = Integer.parseInt(line[1]);
                int y = Integer.parseInt(line[2]);
                //	?
            } else if (line[0].equals("dibujar"))
                dibujar();
            else
                System.out.println("Comando no válido");

        } while (true);
    }

    public void setDibujo(Dibujo dibujo) {
        this.dibujo = dibujo;
    }

    public Dibujo getDibujo() {
        return dibujo;
    }

}
