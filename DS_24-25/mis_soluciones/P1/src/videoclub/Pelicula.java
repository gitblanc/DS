package videoclub;

import videoclub.categorias.Categoria;

public class Pelicula {

	private String titulo;
	private Categoria categoria;

	public Pelicula(String t, Categoria c) {
		this.titulo = t;
		this.categoria = c;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public double getPrecio(Alquiler alquiler) {
		return categoria.getPrecio(alquiler);
	}

	public int getPuntos(Alquiler alquiler) {
		return categoria.getPuntos(alquiler);
	}

}
