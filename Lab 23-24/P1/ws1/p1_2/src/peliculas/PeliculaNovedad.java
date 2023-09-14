package peliculas;

import videoclub.Alquiler;

public class PeliculaNovedad implements TipoPelicula {

	@Override
	public int getPuntos(Alquiler alquiler) {
		return alquiler.getDias() > 1 ? 2 : 1;
	}

	@Override
	public double getPrecio(Alquiler alquiler) {
		return alquiler.getDias() * 3;
	}

}
