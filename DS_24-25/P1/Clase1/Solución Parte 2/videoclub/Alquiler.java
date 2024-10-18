package videoclub;

public class Alquiler {
    private Pelicula pelicula;
    private int dias;

    public Alquiler(Pelicula pelicula, int dias) {
        this.pelicula = pelicula;
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    int getPuntos() {
        return pelicula.getPuntos(dias);
    }

    double getPrecio() {
        return pelicula.getPrecio(dias);
    }
}
