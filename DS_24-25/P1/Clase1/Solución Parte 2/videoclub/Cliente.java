package videoclub;

import java.util.*;

public class Cliente {
    private String nombre;
    private List<Alquiler> alquileres = new ArrayList<Alquiler>();

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

            double precioAlquiler = alquiler.getPrecio();
            int puntosAlquiler = alquiler.getPuntos();

            // 3) Acumula los totales
            totalPrecio += precioAlquiler;
            totalPuntos += puntosAlquiler;

            // 4) Muestra el importe de este alquiler
            System.out.println("\t- " + alquiler.getPelicula().getTitulo() + "\t" + precioAlquiler + "€");
        }

        System.out.println("La deuda es de " + totalPrecio + "€.\n");
        System.out.println("Ha obtenido " + totalPuntos + " puntos en tu tarjeta.");
    }
}
