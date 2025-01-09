/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.*;

import editor.core.EditorWindow;

public class Main {

    public static void main(String[] args) throws IOException {

        EditorWindow editor = new EditorWindow();

        simulateMouse(editor);
    }

    public static void simulateMouse(EditorWindow editor) throws IOException {

        System.out.println("\nActivación de Herramientas: rectangulo | circulo | triangulo | seleccion");
        System.out.println("Acciones de Ratón: pinchar x,y | mover x,y | soltar x,y");
        System.out.println("Acciones del Historial: undo | redo");
        System.out.println("Otros Comandos: dibujar | exit \n");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("> ");
            String[] line = in.readLine().split("[ ,]");

            if (line[0].equals("exit"))
                return;

            //$ Pulsación de los botones de las herramientas -----------------------------

            if (line[0].startsWith("rec"))
                editor.toolButtonClicked("rectangulo");

            else if (line[0].startsWith("cir"))
                editor.toolButtonClicked("circulo");

            else if (line[0].startsWith("tri"))
                editor.toolButtonClicked("triangulo");

            else if (line[0].startsWith("sel"))
                editor.toolButtonClicked("seleccion");

            //$ Acciones del Ratón -----------------------------

            else if (line[0].startsWith("pin"))
                editor.mousePressed(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            else if (line[0].startsWith("mov"))
                editor.mouseMoved(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            else if (line[0].startsWith("sol"))
                editor.mouseReleased(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            //$ Comandos del Historial -----------------------------

            else if (line[0].startsWith("und"))
                editor.undo();

            else if (line[0].startsWith("red"))
                editor.redo();

            //$ Otros comandos -----------------------------

            else if (line[0].startsWith("dib"))
                editor.dibuja();

            else
                System.out.println("Comando no válido");

        } while (true);
    }

}
