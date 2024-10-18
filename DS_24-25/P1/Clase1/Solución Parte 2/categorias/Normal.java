package categorias;

import videoclub.Categoria;

public class Normal implements Categoria {

    public double getPrecio(int dias) {
        double precio = 2;
        if (dias > 2)
            precio += (dias - 2) * 1.5;
        return precio;
    }

    public int getPuntos(int dias) {
        return 1;
    }

}
