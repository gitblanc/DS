package categorias;

import videoclub.Categoria;

public class Novedad implements Categoria {

    public double getPrecio(int dias) {
        return dias * 3;
    }

    public int getPuntos(int dias) {
        return (dias > 1) ? 2 : 1;
    }
}
