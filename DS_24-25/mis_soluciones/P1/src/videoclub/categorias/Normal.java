/**
 * 
 */
package videoclub.categorias;

import videoclub.Alquiler;

/**
 * 
 */
public class Normal implements Categoria {
	@Override
	public double getPrecio(Alquiler alquiler) {
		double precioAlquiler = 2;
		if (alquiler.getDias() > 2)
			precioAlquiler += (alquiler.getDias() - 2) * 1.5;
		return precioAlquiler;
	}

	@Override
	public int getPuntos(Alquiler alquiler) {
		return 1;
	}
}
