package videoclub.categorias;

import videoclub.Alquiler;

public interface Categoria {
	public double getPrecio(Alquiler alquiler);

	public int getPuntos(Alquiler alquiler);
}
