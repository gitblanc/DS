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

            // 1) Calcula el importe de cada alquiler
            double precioAlquiler = getPrecioAlquiler(alquiler);

            // 2) Cada alquiler da 1 punto. Punto extra para novedades alquiladas 2 o más días
            int puntosAlquiler = getPuntosAlquiler(alquiler);

            // 3) Acumula los totales
            totalPrecio += precioAlquiler;
            totalPuntos += puntosAlquiler;

            // 4) Muestra el importe de este alquiler
            System.out.println("\t- " + alquiler.getPelicula().getTitulo() + "\t" + precioAlquiler + "€");

        }

        System.out.println("La deuda es de " + totalPrecio + "€.\n");
        System.out.println("Ha obtenido " + totalPuntos + " puntos en tu tarjeta.");
    }

	private int getPuntosAlquiler(Alquiler alquiler) {
		return alquiler.getPuntos();
	}

	private double getPrecioAlquiler(Alquiler alquiler) {
		return alquiler.getPrecio();
	}
}