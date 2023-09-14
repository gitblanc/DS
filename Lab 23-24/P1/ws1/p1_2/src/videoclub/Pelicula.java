package videoclub;

import peliculas.TipoPelicula;

public class Pelicula {
	private String titulo;

	private TipoPelicula tipo;

	public Pelicula(String titulo, TipoPelicula tipo) {
		this.titulo = titulo;
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	int getPuntos(Alquiler alquiler) {
//		int puntosAlquiler = 1;
//		if ((alquiler.getPelicula().getCategoria() == TipoPelicula.NOVEDAD) && alquiler.getDias() > 1)
//		    puntosAlquiler = 2;
//		return puntosAlquiler;

		return getTipo().getPuntos(alquiler);
	}

	private TipoPelicula getTipo() {
		return this.tipo;
	}

	double getPrecio(Alquiler alquiler) {
//		double precioAlquiler = 0;
//		switch (alquiler.getPelicula().getCategoria()) {
//		case Pelicula.NOVEDAD:
//			precioAlquiler += alquiler.getDias() * 3;
//			break;
//		case Pelicula.NORMAL:
//			precioAlquiler += 2;
//			if (alquiler.getDias() > 2)
//				precioAlquiler += (alquiler.getDias() - 2) * 1.5;
//			break;
//		case Pelicula.INFANTIL:
//			precioAlquiler += 1.5;
//			if (alquiler.getDias() > 3)
//				precioAlquiler += (alquiler.getDias() - 3) * 1.5;
//			break;
//		}
//		return precioAlquiler;

		return getTipo().getPrecio(alquiler);
	}
}
