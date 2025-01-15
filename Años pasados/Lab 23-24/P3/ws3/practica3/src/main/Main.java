/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.*;

import editor.*;
import tools.CircleTool;
import tools.RectangleTool;
import tools.TriangleTool;

public class Main {

    public static void main(String[] args) throws IOException {
        Editor editor = new Editor();
        Menu menu = new Menu(editor);
        
        menu.addTool("seleccion", editor.getDefaultTool());
        menu.addTool("rectangulo", new RectangleTool(editor));
        menu.addTool("circulo", new CircleTool(editor));
        menu.addTool("triangulo", new TriangleTool(editor));
        
        menu.run();
    }

}
