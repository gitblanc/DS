package formulario;

import java.io.*;

public class CampoTexto implements Campo {

    private String etiqueta;

    public CampoTexto(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void pideDato() {
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

        boolean valido;
        do {
            valido = true;
            try {
                System.out.print(etiqueta + ": ");
                texto = consola.readLine();

                // Comprobar si el texto introducido está formado por letras
                for (char ch : texto.toCharArray()) {
                    if (!Character.isLetter(ch)) {
                        valido = false;
                        break;
                    }
                }

            } catch (IOException ex) {
                System.out.println(ex);
            }

        } while (!valido);
    }

    public String getDato() {
        return texto;
    }

    private String texto;
}
