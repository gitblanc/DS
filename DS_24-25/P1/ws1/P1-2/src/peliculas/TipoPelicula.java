package peliculas;

import videoclub.Alquiler;

public interface TipoPelicula {
	double getPrecio(Alquiler alquiler);

	int getPuntosAlquiler(Alquiler alquiler);
}
