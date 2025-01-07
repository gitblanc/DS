package videoclub;

import java.util.*;

public class Cliente {
	private String nombre;
	private List<Alquiler> alquileres = new ArrayList<>();

	public Cliente(String nombre) {
		this.nombre = nombre;
	}

	public void addAlquiler(Alquiler alquiler) {
		alquileres.add(alquiler);
	}

	public String getNombre() {
		return nombre;
	}

	public void imprimeInforme() {
		double totalPrecio = 0;
		int totalPuntos = 0;
		System.out.println("Informe de los alquileres de: " + getNombre());

		for (Alquiler alquiler : alquileres) {
			totalPrecio = alquiler.calculaPrecio();
			totalPuntos += alquiler.calculaPuntos();

			System.out.println("\t- " + alquiler.getPelicula().getTitulo() + "\t" + totalPrecio + "€");

		}

		System.out.println("La deuda es de " + totalPrecio + "€.\n");
		System.out.println("Ha obtenido " + totalPuntos + " puntos en tu tarjeta.");
	}
}
