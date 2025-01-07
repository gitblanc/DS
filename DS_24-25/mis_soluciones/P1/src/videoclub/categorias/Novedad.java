/**
 * 
 */
package videoclub.categorias;

import videoclub.Alquiler;

/**
 * 
 */
public class Novedad implements Categoria {
	@Override
	public double getPrecio(Alquiler alquiler) {
		return alquiler.getDias() * 3;
	}

	@Override
	public int getPuntos(Alquiler alquiler) {
		if (alquiler.getDias() > 1)
			return 2;
		return 1;
	}

}
