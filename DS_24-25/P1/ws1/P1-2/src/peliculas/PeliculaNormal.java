package peliculas;

import videoclub.Alquiler;

public class PeliculaNormal implements TipoPelicula {

	@Override
	public double getPrecio(Alquiler alquiler) {
		double precioAlquiler = 2;
		if (alquiler.getDias() > 2)
			precioAlquiler += (alquiler.getDias() - 2) * 1.5;
		return precioAlquiler;
	}

	@Override
	public int getPuntosAlquiler(Alquiler alquiler) {
		return 1;
	}

}