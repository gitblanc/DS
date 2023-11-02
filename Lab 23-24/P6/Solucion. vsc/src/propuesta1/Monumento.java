package propuesta1;

import google.maps.*;

public class Monumento implements Marcador {
    // ----------------------------------------------
    // Este código sería el mismo... ----------------
    private String nombre;
    private String autor;
    private String dirección;

    public Monumento(String nombre, String author, String address) {
        this.nombre = nombre;
        this.autor = author;
        this.dirección = address;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getDirección() {
        return dirección;
    }

    // ----------------------------------------------------
    // ... y habría que añadir los métodos de Marcador ----
    public Coordenadas getCoordenadas() {
        return null; /* Hacerlo */
    }

    public String pulsaciónCorta() {
        return null; /* Hacerlo */
    }

    public void pulsaciónLarga() {
        /* Hacerlo */
    }
}
