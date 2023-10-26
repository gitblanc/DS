package adapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Restaurante;

public class RestauranteAdapter implements MarkerConAutor, Marcador {

	private Restaurante rest;
	private Navegador nav = new Navegador();

	public RestauranteAdapter(Restaurante r) {
		this.rest = r;
	}

	@Override
	public Coordenadas getCoordenadas() {
		return nav.getCoordenadas(rest.getDirección());
	}

	@Override
	public String pulsaciónCorta() {
		return "Nombre: " + rest.getNombre() + ", Teléfono de reservas: " + rest.getTeléfono();
	}

	@Override
	public void pulsaciónLarga() {
		rest.llamar();
	}

	@Override
	public String getAutor() {
		return rest.getNombre();
	}

	@Override
	public String getDirección() {
		return rest.getDirección();
	}

	@Override
	public void setAutor(String texto) {
		rest.setNombre(texto);
	}

	@Override
	public void setDirección(String texto) {
		rest.setDirección(texto);
	}

}
