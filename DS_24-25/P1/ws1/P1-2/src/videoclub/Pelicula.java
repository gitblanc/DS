package videoclub;

import peliculas.TipoPelicula;

public class Pelicula {
    private String titulo;
    private TipoPelicula categoria;

//    public static final int NORMAL = 0;
//    public static final int NOVEDAD = 1;
//    public static final int INFANTIL = 2;

    public Pelicula(String titulo, TipoPelicula categoria) {
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public TipoPelicula getCategoria() {
        return categoria;
    }

    public void setCategoria(TipoPelicula categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

	public double getPrecioAlquiler(Alquiler alquiler) {
		return getCategoria().getPrecio(alquiler);
//		double precioAlquiler = 0;
//		switch (getCategoria()) {
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
	}

	public int getPuntos(Alquiler alquiler) {
		return getCategoria().getPuntosAlquiler(alquiler);
//		int puntosAlquiler = 1;
//		if ((getCategoria() == Pelicula.NOVEDAD) && alquiler.getDias() > 1)
//			puntosAlquiler = 2;
//		return puntosAlquiler;
	}
}