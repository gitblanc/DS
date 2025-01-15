package zNoHacerEsto;

// No es buena idea usar el Template Method en este ejercicio:
// a) Complica el combinar validaciones.
// b) Las validaciones no se podrían reutilizar en un entorno gráfico, ya que las validaciones están
// acopladas al código que pide los datos por consola.

import java.io.*;

public abstract class Campo {

    protected Campo(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void pideDato() {
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                System.out.print(etiqueta + ": ");
                texto = consola.readLine();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } while (!isValid(texto));
    }

    protected abstract boolean isValid(String texto2);

    public String getDato() {
        return texto;
    }

    private String texto;
    private String etiqueta;
}
