/**
 * 
 */
package videoclub.categorias;

import videoclub.Alquiler;

/**
 * 
 */
public class Infantil implements Categoria {

	@Override
	public double getPrecio(Alquiler alquiler) {
		double precioAlquiler = 1.5;
		if (alquiler.getDias() > 3)
			precioAlquiler += (alquiler.getDias() - 3) * 1.5;
		return precioAlquiler;
	}

	@Override
	public int getPuntos(Alquiler alquiler) {
		return 1;
	}

}
