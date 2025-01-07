package videoclub;

public class Alquiler {
	private Pelicula pelicula;
	private int dias;

	public Alquiler(Pelicula pelicula, int dias) {
		this.pelicula = pelicula;
		this.dias = dias;
	}

	public int getDias() {
		return dias;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public double calculaPrecio() {
		return pelicula.getPrecio(this);
	}

	public double calculaPuntos() {
		return pelicula.getPuntos(this);
	}
}
