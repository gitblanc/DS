package formulario;

import java.io.*;

public class CampoValoresPredefinidos implements Campo {

    private String etiqueta;
    private String[] valores;

    public CampoValoresPredefinidos(String etiqueta, String... valores) {
        this.etiqueta = etiqueta;
        this.valores = valores;
    }

    public void pideDato() {
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

        boolean valido;
        do {
            valido = false;
            try {
                System.out.print(etiqueta + ": ");
                texto = consola.readLine();

                // Comprobar si el texto introducido está entre los valores permitidos
                for (String valor : valores) {
                    if (texto.equalsIgnoreCase(valor)) {
                        valido = true;
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
