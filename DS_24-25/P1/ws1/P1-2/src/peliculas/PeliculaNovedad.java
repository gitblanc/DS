package peliculas;

import videoclub.Alquiler;

public class PeliculaNovedad implements TipoPelicula{

	@Override
	public double getPrecio(Alquiler alquiler) {
		return alquiler.getDias() * 3;
	}

	@Override
	public int getPuntosAlquiler(Alquiler alquiler) {
		if(alquiler.getDias() > 1)
			return 2;
		return 1;
	}

}
